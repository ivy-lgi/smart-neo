package com.axonivy.smart.neo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TestSmartNeoResource {

  SmartNeoResource resource = new SmartNeoResource();

  @Test
  void testHelloWorld() {
    assertThat(resource.helloWorld()).isEqualTo("Hello, World!");
  }
}
