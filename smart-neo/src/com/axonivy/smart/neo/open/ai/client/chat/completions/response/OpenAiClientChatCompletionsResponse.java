package com.axonivy.smart.neo.open.ai.client.chat.completions.response;

import java.util.List;

public record OpenAiClientChatCompletionsResponse(List<Choice> choices) {
  public static record Choice(Message message) {
    public static record Message(String content) {}
  }
}
