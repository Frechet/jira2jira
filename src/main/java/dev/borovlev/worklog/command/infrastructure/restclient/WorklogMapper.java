package dev.borovlev.worklog.command.infrastructure.restclient;

import dev.borovlev.worklog.command.domain.Worklog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper
public interface WorklogMapper {
  @Mapping(target = "projectKey", source = "issue.summary")
  @Mapping(target = "summary", source = "issue.summary")
  @Mapping(target = "projecttimeSpentSecondsKey", source = "issue.timeSpentSeconds")
  @Mapping(target = "worker.username", source = "issue.summary")
  @Mapping(target = "issue.issueKey", source = "issue.summary")
  @Mapping(target = "issue.issueType", source = "issue.summary")
  @Mapping(target = "issue.parentKey", source = "issue.summary")
  Worklog mapDto(TempoWorklogDto dto);

  Set<Worklog> mapDtos(Set<TempoWorklogDto> dtos);
}
