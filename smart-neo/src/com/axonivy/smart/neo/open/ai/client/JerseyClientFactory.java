package com.axonivy.smart.neo.open.ai.client;

import java.util.logging.Logger;

import ch.ivyteam.ivy.jersey.client.JerseyClientBuilder;

public class JerseyClientFactory {

  static final Logger LOGGER = Logger.getLogger(JerseyClientFactory.class.getPackageName());

  public static JerseyClientBuilder create() {
    return JerseyClientBuilder.create("OpenAI Client").logger(LOGGER).useJacksonJson();
  }
}
