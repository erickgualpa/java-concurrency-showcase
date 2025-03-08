package org.egualpam.executorframework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ExecutorFrameworkService {
  void run() {
    try (ExecutorService executorService = Executors.newFixedThreadPool(10); ) {
      System.out.println("Hello from ExecutorFrameworkService");
      if (executorService.isTerminated()) {
        System.out.println("Executor service is terminated");
      }
    } catch (Exception e) {
      System.out.println("Exception occurred: " + e.getMessage());
    }
  }
}
