package dev.borovlev.worklog.command.infrastructure.restclient;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class TempoWorklogCreateRequestDto {
  private String worker;
  private String comment;
  private long timeSpentSeconds;
  private String originTaskId;
  @JsonFormat(pattern="yyyy-MM-dd")
  private LocalDateTime started;
}
