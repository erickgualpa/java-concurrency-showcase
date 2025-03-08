package org.egualpam.executorframework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExecutorFrameworkServiceTest {

  private ExecutorFrameworkService testSubject;

  @BeforeEach
  void setUp() {
    testSubject = new ExecutorFrameworkService();
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
