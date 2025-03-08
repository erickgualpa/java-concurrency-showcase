package org.egualpam.executorframework;

import static java.time.Instant.now;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CompletableFutureWrapperTest {

  private CompletableFutureWrapper testSubject;

  @BeforeEach
  void setUp() {
    testSubject = new CompletableFutureWrapper();
  }

  @Test
  void runAsync() {
    final Instant timeout = now().plusMillis(5000);

    testSubject.runAsync();

    while (testSubject.getTasks().size() < 10 && now().isBefore(timeout)) {
      System.out.println("Waiting for tasks to complete");
    }
  }

  @Test
  void runSync() {
    testSubject.runSync();

    Set<Integer> tasks = testSubject.getTasks();
    assertEquals(10, tasks.size());
  }
}
