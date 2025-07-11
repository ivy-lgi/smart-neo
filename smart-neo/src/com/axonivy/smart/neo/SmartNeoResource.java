package com.axonivy.smart.neo;

import static com.axonivy.smart.neo.SmartNeoResources.PATH;
import static com.axonivy.smart.neo.SmartNeoResources.TAG;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import io.swagger.v3.oas.annotations.tags.Tag;

@Path(PATH)
@Tag(name = TAG)
public class SmartNeoResource {

  @GET
  @Produces(TEXT_PLAIN)
  public String helloWorld() {
    return "Hello, World!";
  }
}
