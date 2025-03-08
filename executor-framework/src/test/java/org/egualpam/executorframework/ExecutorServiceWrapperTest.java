package org.egualpam.executorframework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExecutorServiceWrapperTest {

  private ExecutorServiceWrapper testSubject;

  @BeforeEach
  void setUp() {
    testSubject = new ExecutorServiceWrapper();
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
