package org.egualpam.executorframework;

import static java.util.stream.IntStream.range;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ExecutorServiceSimpleExample {
  void runNonBlocking() {
    try (ExecutorService executorService = Executors.newFixedThreadPool(10)) {
      range(0, 10).forEach(i -> executorService.submit(() -> expensiveTask(i)));
    } catch (Exception e) {
      System.out.println("Exception occurred: " + e.getMessage());
    }
  }

  void runBlocking() {
    range(0, 10).forEach(ExecutorServiceSimpleExample::expensiveTask);
  }

  private static void expensiveTask(int i) {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("Thread: " + i + " " + Thread.currentThread().getName());
  }
}
