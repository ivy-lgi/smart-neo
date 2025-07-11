package com.axonivy.smart.neo.open.ai.client;

import static com.axonivy.smart.neo.open.ai.client.OpenAiClientConstants.OPEN_AI_API_KEY_KEY;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import com.axonivy.smart.neo.open.ai.client.impl.OpenAiClientImpl;

import ch.ivyteam.ivy.configuration.restricted.IConfiguration;

public interface OpenAiClient {
  OpenAiRequest request();

  public interface OpenAiRequest {
    OpenAiRequest path(String path);
    Response post(Entity<?> entity);
  }

  static OpenAiClientImpl create() {
    var apiKey = IConfiguration.instance().get(OPEN_AI_API_KEY_KEY).orElseThrow(
        () -> new IllegalStateException("OpenAI API key is not configured. Set the key in the ivy.yaml."));
    return new OpenAiClientImpl(JerseyClientFactory.create().toClient(), apiKey);
  }
}
