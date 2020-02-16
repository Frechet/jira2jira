package dev.borovlev.worklog.command.application;

import dev.borovlev.worklog.command.domain.Worklog;
import dev.borovlev.worklog.common.WorklogTransferProperties;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.Set;

@Service
@AllArgsConstructor(onConstructor = @__(@Inject))
public class WorklogService {

  private WorklogTransferProperties worklogTransferProperties;
  private WorklogExtractorService worklogExtractorService;
  private WorklogTransferService worklogTransferService;

  public Set<Worklog> transferWorklog() {
    // get worklog from source jira
    Set<Worklog> source = worklogExtractorService.extract(LocalDateTime.now().minusDays(1));
    // map worklog from source jira to target jira
    // create not existed issues
    // put worklog to target jira
    worklogTransferService.transfer(source);
    // map worklog to domain
    // return domain worklog
    return source;
  }
}
