package org.egualpam;

import static java.util.stream.IntStream.range;

import java.util.HashSet;
import java.util.Set;

class BasicThreadingWrapper {

  private final Set<Integer> values = new HashSet<>();

  Set<Integer> getTasks() {
    return values;
  }

  void runBlocking(int tasksAmount) {
    range(0, tasksAmount).forEach(this::expensiveTask);
  }

  void runNonBlocking(int tasksAmount) {
    range(0, tasksAmount)
        .forEach(
            i -> {
              Runnable runnable = () -> expensiveTask(i);
              Thread thread = new Thread(runnable);
              thread.start();
            });
  }

  private void expensiveTask(int i) {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    values.add(i);

    System.out.println("Thread: " + i + " " + Thread.currentThread().getName());
  }
}
