package com.axonivy.smart.neo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TestImpl {

  @Test
  void testRun() {
    assertThat(Impl.run()).isEqualTo("Hello, World!");
  }
}
