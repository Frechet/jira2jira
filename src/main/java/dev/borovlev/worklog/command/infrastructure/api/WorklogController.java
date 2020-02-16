package dev.borovlev.worklog.command.infrastructure.api;

import dev.borovlev.worklog.command.application.WorklogService;
import dev.borovlev.worklog.command.domain.Worklog;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.Set;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor(onConstructor = @__(@Inject))
public class WorklogController {

  private WorklogService worklogService;

  @GetMapping("/worklog")
  public Set<Worklog> worklog() {
    return worklogService.transferWorklog();
  }
}
