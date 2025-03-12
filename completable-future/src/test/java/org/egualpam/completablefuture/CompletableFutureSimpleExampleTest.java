package org.egualpam.completablefuture;

import static java.time.Instant.now;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CompletableFutureSimpleExampleTest {

  private CompletableFutureSimpleExample testSubject;

  @BeforeEach
  void setUp() {
    testSubject = new CompletableFutureSimpleExample();
  }

  @Test
  void runAsync() {
    final int tasksAmount = 10;
    final Instant timeout = now().plusMillis(5000);

    testSubject.runAsync();

    while (testSubject.getTasks().size() < tasksAmount && now().isBefore(timeout)) {
      System.out.println("Waiting for tasks to complete");
    }

    assertEquals(tasksAmount, testSubject.getTasks().size());
  }

  @Test
  void runSync() {
    testSubject.runSync();

    Set<Integer> tasks = testSubject.getTasks();
    assertEquals(10, tasks.size());
  }
}
