package dev.borovlev.worklog.command.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Worklog {

  @Getter
  @Builder
  @AllArgsConstructor
  public static class State {
    private Worker worker;
    private String projectKey;
    private Issue issue;
    private String summary;
    private long timeSpentSeconds;

    @Getter
    @Builder
    @AllArgsConstructor
    public static class Worker {
      private String username;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class Issue {
      String issueKey;
      int issueType;
    }
  }
}
