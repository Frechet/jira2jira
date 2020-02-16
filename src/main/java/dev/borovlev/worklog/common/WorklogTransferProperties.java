package dev.borovlev.worklog.common;

import io.quarkus.arc.config.ConfigProperties;
import lombok.Data;

import java.util.List;

@Data
@ConfigProperties(prefix = "worklog")
public class WorklogTransferProperties {

  private String sourceJiraAuth;
  private String targetJiraAuth;
  private String sourceJiraProject;
  private String targetJiraProject;
  private List<String> usernames;
  private List<String> passes;

}
