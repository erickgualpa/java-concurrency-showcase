package org.egualpam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BasicThreadingWrapperTest {

  private BasicThreadingWrapper testSubject;

  @BeforeEach
  void setUp() {
    testSubject = new BasicThreadingWrapper();
  }

  @Test
  void runBlocking() {
    testSubject.runBlocking();
  }

  @Test
  void runNonBlocking() {
    testSubject.runNonBlocking();
  }
}
