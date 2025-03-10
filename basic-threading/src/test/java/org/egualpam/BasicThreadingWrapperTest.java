package org.egualpam;

import static java.time.Instant.now;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
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
    int tasksAmount = 10;

    testSubject.runBlocking(tasksAmount);

    assertEquals(tasksAmount, testSubject.getTasks().size());
  }

  @Test
  void runNonBlocking() {
    final int tasksAmount = 10;
    final Instant timeout = now().plusMillis(5000);

    testSubject.runNonBlocking(tasksAmount);

    while (testSubject.getTasks().size() < tasksAmount && now().isBefore(timeout)) {
      System.out.println("Waiting for tasks to complete");
    }

    assertEquals(tasksAmount, testSubject.getTasks().size());
  }
}
