package com.axonivy.smart.neo.open.ai.client;

import ch.ivyteam.ivy.configuration.restricted.ConfigKey;

public interface OpenAiClientConstants {
  String URL = "https://api.openai.com/v1";

  ConfigKey OPEN_AI_KEY = ConfigKey.create("SmartNeo").append("OpenAi");
  ConfigKey OPEN_AI_API_KEY_KEY = OPEN_AI_KEY.append("ApiKey");
  ConfigKey OPEN_AI_MODEL_KEY = OPEN_AI_KEY.append("Model");
}
