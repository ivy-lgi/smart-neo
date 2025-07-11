package com.axonivy.smart.neo.open.ai.client.chat.completions.arguments;

import java.util.List;

public record OpenAiClientChatCompletionsArguments(String model, List<Message> messages) {

  public static Builder builder() {
    return new Builder();
  }

  public static record Message(String role, String content) {

    public static Builder builder() {
      return new Builder();
    }

    @SuppressWarnings("hiding")
    public static class Builder {
      private String role;
      private String content;

      public Builder role(String role) {
        this.role = role;
        return this;
      }

      public Builder content(String content) {
        this.content = content;
        return this;
      }

      public Message build() {
        return new Message(role, content);
      }
    }
  }

  @SuppressWarnings("hiding")
  public static class Builder {
    private String model;
    private List<Message> messages;

    public Builder model(String model) {
      this.model = model;
      return this;
    }

    public Builder messages(List<Message> messages) {
      this.messages = messages;
      return this;
    }

    public OpenAiClientChatCompletionsArguments build() {
      return new OpenAiClientChatCompletionsArguments(model, messages);
    }
  }
}
