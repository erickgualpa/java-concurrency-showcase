package org.egualpam.executorframework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExecutorServiceSimpleExampleTest {

  private ExecutorServiceSimpleExample testSubject;

  @BeforeEach
  void setUp() {
    testSubject = new ExecutorServiceSimpleExample();
  }

  @Test
  void runNonBlocking() {
    testSubject.runNonBlocking();
  }

  @Test
  void runBlocking() {
    testSubject.runBlocking();
  }
}
