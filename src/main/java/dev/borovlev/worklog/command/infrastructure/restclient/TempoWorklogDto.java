package dev.borovlev.worklog.command.infrastructure.restclient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown=true)
@Data
public class TempoWorklogDto {
  private Issue issue;
  @JsonFormat(pattern="yyyy-MM-dd")
  private LocalDateTime started;

  @JsonIgnoreProperties(ignoreUnknown=true)
  @Data
  public static class Issue {
    private long timeSpentSeconds;
    private String parentKey;
    private String summary;
    private String comment;
  }
}
