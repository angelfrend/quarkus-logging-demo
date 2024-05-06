package org.example;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.UUID;

@Path("/hello")
public class ExampleResource {

    Logger log = LoggerFactory.getLogger(ExampleResource.class);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        MDC.put("correlation_id", UUID.randomUUID().toString());
        log.info("Sample log from Get Method");
        return "Hello from Quarkus REST";
    }
}
