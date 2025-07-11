package com.axonivy.smart.neo.chat.completions;

import static com.axonivy.smart.neo.SmartNeoResources.PATH;
import static com.axonivy.smart.neo.SmartNeoResources.TAG;
import static com.axonivy.smart.neo.open.ai.client.OpenAiClientConstants.OPEN_AI_MODEL_KEY;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Entity;

import com.axonivy.smart.neo.chat.completions.arguments.SmartNeoChatCompletionsArguments;
import com.axonivy.smart.neo.open.ai.client.OpenAiClient;
import com.axonivy.smart.neo.open.ai.client.chat.completions.arguments.OpenAiClientChatCompletionsArguments;
import com.axonivy.smart.neo.open.ai.client.chat.completions.arguments.OpenAiClientChatCompletionsArguments.Message;
import com.axonivy.smart.neo.open.ai.client.chat.completions.response.OpenAiClientChatCompletionsResponse;

import ch.ivyteam.ivy.configuration.restricted.IConfiguration;
import io.swagger.v3.oas.annotations.tags.Tag;

@Path(PATH + "/chat/completions")
@Tag(name = TAG)
public class SmartNeoChatCompletionsResource {

  @POST
  @Consumes(APPLICATION_JSON)
  @Produces(TEXT_PLAIN)
  public String chatCompletions(SmartNeoChatCompletionsArguments args) {
    var openAiModel = IConfiguration.instance().get(OPEN_AI_MODEL_KEY).orElseThrow(
        () -> new IllegalStateException("OpenAI model is not configured. Set the model in the ivy.yaml."));

    var openAiClient = OpenAiClient.create();
    var openAiClientChatCompletionsArguments = OpenAiClientChatCompletionsArguments.builder()
        .model(openAiModel)
        .messages(List.of(Message.builder().role("user").content(args.content()).build()))
        .build();

    var response = openAiClient.request()
        .path("chat")
        .path("completions")
        .post(Entity.json(openAiClientChatCompletionsArguments))
        .readEntity(OpenAiClientChatCompletionsResponse.class);
    return response.choices().get(0).message().content();
  }
}
