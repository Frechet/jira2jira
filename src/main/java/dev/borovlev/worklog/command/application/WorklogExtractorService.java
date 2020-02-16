package dev.borovlev.worklog.command.application;

import dev.borovlev.worklog.command.domain.Worklog;
import dev.borovlev.worklog.command.infrastructure.restclient.SourceJiraTempoRestService;
import dev.borovlev.worklog.command.infrastructure.restclient.TempoWorklogDto;
import dev.borovlev.worklog.command.infrastructure.restclient.TempoWorklogSearchRequestDto;
import dev.borovlev.worklog.command.infrastructure.restclient.WorklogMapper;
import dev.borovlev.worklog.common.WorklogTransferProperties;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Set;

@Slf4j
@Service
public class WorklogExtractorService {

  @RestClient
  private SourceJiraTempoRestService sourceJiraTempoRestService;
  @Inject
  private WorklogTransferProperties worklogTransferProperties;
  @Inject
  private WorklogMapper mapper;

  public Set<Worklog> extract(LocalDateTime extractionDate) {
    // TODO: mapper
    TempoWorklogSearchRequestDto requestDto = new TempoWorklogSearchRequestDto();
    requestDto.setFrom(extractionDate);
    requestDto.setProjectKey(Collections.singletonList(worklogTransferProperties.getSourceJiraProject()));
    requestDto.setWorker(worklogTransferProperties.getUsernames());

    Set<TempoWorklogDto> tempoWorklogDtos = sourceJiraTempoRestService
        .searchWorklogs(worklogTransferProperties.getSourceJiraAuth(), requestDto);
    log.info("Extract worklogs: {}", tempoWorklogDtos);
    return mapper.mapDtos(tempoWorklogDtos);
  }
}
