package dev.borovlev.worklog.command.application;

import dev.borovlev.worklog.command.domain.Worklog;
import dev.borovlev.worklog.command.infrastructure.restclient.TargetJiraTempoRestService;
import dev.borovlev.worklog.command.infrastructure.restclient.TempoWorklogCreateRequestDto;
import dev.borovlev.worklog.command.infrastructure.restclient.WorklogMapper;
import dev.borovlev.worklog.common.WorklogTransferProperties;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Set;

@Slf4j
@Service
public class WorklogTransferService {

  @RestClient
  private TargetJiraTempoRestService targetJiraTempoRestService;
  @Inject
  private WorklogTransferProperties worklogTransferProperties;
  @Inject
  private WorklogMapper mapper;

  public Set<Worklog> transfer(Set<Worklog> toTransfer) {
    toTransfer.stream()
        .map(w -> {
          // TODO mapper
          TempoWorklogCreateRequestDto request = new TempoWorklogCreateRequestDto();
          return request;
        })
        .forEach(r -> targetJiraTempoRestService.createWorklog(worklogTransferProperties.getTargetJiraAuth(), r));
    return toTransfer;
  }
}
