package dev.borovlev.worklog.command.infrastructure.restclient;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class TempoWorklogSearchRequestDto {
  @JsonFormat(pattern="yyyy-MM-dd")
  private LocalDateTime from;
//  @JsonFormat(pattern="yyyy-MM-dd")
//  private LocalDateTime to;
  private List<String> projectKey;
  private List<String> worker;
}
