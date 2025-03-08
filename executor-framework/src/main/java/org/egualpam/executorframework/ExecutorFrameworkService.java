package org.egualpam.executorframework;

import static java.util.stream.IntStream.range;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ExecutorFrameworkService {
  void runNonBlocking() {
    try (ExecutorService executorService = Executors.newFixedThreadPool(10)) {
      range(0, 10).forEach(i -> executorService.submit(() -> printThreadName(i)));
    } catch (Exception e) {
      System.out.println("Exception occurred: " + e.getMessage());
    }
  }

  void runBlocking() {
    range(0, 10).forEach(ExecutorFrameworkService::printThreadName);
  }

  private static void printThreadName(int i) {
    System.out.println("Thread: " + i + " " + Thread.currentThread().getName());
  }
}
