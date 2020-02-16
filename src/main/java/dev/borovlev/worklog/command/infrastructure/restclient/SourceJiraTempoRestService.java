package dev.borovlev.worklog.command.infrastructure.restclient;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Set;

/**
 * https://www.tempo.io/server-api-documentation/timesheets#operation/searchWorklogs
 * Example:
 * curl -H "Authorization: Basic ???=" -d '{}' -X POST -H "Content-Type: application/json"
 * https://????/rest/tempo-timesheets/4/worklogs/search
 */
@Path("/rest/tempo-timesheets/4")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "source-jira-tempo-api")
@RegisterProvider(CommonsRequestLoggingFilter.class)
public interface SourceJiraTempoRestService {

  @POST
  @Path("/worklogs/search")
  Set<TempoWorklogDto>  searchWorklogs(@HeaderParam("Authorization") String authorization, TempoWorklogSearchRequestDto entity);

}
