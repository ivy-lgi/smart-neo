package com.axonivy.smart.neo.open.ai.client.impl;

import static com.axonivy.smart.neo.open.ai.client.OpenAiClientConstants.URL;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.axonivy.smart.neo.open.ai.client.OpenAiClient;

public class OpenAiClientImpl implements OpenAiClient {

  private final Client client;
  private final String apiKey;

  public OpenAiClientImpl(Client client, String apiKey) {
    this.client = client;
    this.apiKey = apiKey;
  }

  @Override
  public OpenAiRequest request() {
    return new OpenAiRequestImpl().apiKey(apiKey);
  }

  @SuppressWarnings("hiding")
  public final class OpenAiRequestImpl implements OpenAiRequest {

    private WebTarget target;
    private String apiKey;

    private OpenAiRequestImpl() {
      this.target = client.target(URL);
    }

    private OpenAiRequestImpl apiKey(String apiKey) {
      this.apiKey = apiKey;
      return this;
    }

    @Override
    public OpenAiRequestImpl path(String path) {
      this.target = target.path(path);
      return this;
    }

    @Override
    public Response post(Entity<?> entity) {
      return request().post(entity);
    }

    private Invocation.Builder request() {
      return target.request().header(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey);
    }
  }
}
