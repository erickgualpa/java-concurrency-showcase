package org.egualpam.executorframework;

import static java.util.stream.IntStream.range;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

class CompletableFutureWrapper {

  private final Set<Integer> tasks = new HashSet<>();

  void runAsync() {
    range(0, 10).forEach(i -> CompletableFuture.runAsync(() -> expensiveTask(i)));
  }

  void runSync() {
    range(0, 10).forEach(this::expensiveTask);
  }

  private void expensiveTask(int i) {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    tasks.add(i);

    System.out.println("Thread: " + i + " " + Thread.currentThread().getName());
  }

  Set<Integer> getTasks() {
    return tasks;
  }
}
