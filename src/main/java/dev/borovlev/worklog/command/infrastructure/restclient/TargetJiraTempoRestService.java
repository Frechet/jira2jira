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

@Path("/rest/tempo-timesheets/4")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "target-jira-tempo-api")
@RegisterProvider(CommonsRequestLoggingFilter.class)
public interface TargetJiraTempoRestService {

  @POST
  @Path("/worklogs")
  Set<TempoWorklogDto> createWorklog(@HeaderParam("Authorization") String authorization, TempoWorklogCreateRequestDto entity);

}
