package org.egualpam;

import static org.junit.jupiter.api.AssertionsKt.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BasicThreadingWrapperTest {

  private BasicThreadingWrapper testSubject;

  @BeforeEach
  void setUp() {
    testSubject = new BasicThreadingWrapper();
  }

  @Test
  void nonNull() {
    assertNotNull(testSubject);
  }
}
