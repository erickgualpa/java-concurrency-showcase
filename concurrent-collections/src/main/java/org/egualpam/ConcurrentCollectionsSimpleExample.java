package org.egualpam;

import static java.util.stream.IntStream.range;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ConcurrentCollectionsSimpleExample {

  List<Integer> processUsingRegularCollection(int iterations) {
    final List<Integer> updated = new ArrayList<>();

    Runnable task =
        () -> {
          delay();
          int size = updated.size();
          updated.add(size);
        };

    try (ExecutorService executorService = Executors.newFixedThreadPool(10)) {
      range(0, iterations).forEach(i -> executorService.submit(task));
    } catch (Exception e) {
      System.out.println("Exception occurred: " + e.getMessage());
    }

    return updated;
  }

  List<Integer> processUsingSynchronizedList(int iterations) {
    final List<Integer> updated = Collections.synchronizedList(new ArrayList<>());

    Runnable task =
        () -> {
          delay();
          int size = updated.size();
          synchronized (updated) {
            updated.add(size);
          }
        };

    try (ExecutorService executorService = Executors.newFixedThreadPool(10)) {
      range(0, iterations).forEach(i -> executorService.submit(task));
    } catch (Exception e) {
      System.out.println("Exception occurred: " + e.getMessage());
    }

    return updated;
  }

  private static void delay() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
