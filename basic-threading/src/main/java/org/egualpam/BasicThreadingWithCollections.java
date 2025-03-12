package org.egualpam;

import java.util.HashSet;
import java.util.Set;

class BasicThreadingWithCollections {
  Set<Integer> run(Set<Integer> datasource) {
    Set<Integer> processed = new HashSet<>();
    datasource.forEach(
        i -> {
          Runnable runnable =
              () -> {
                delay();
                if (i == 50) {
                  Integer processedValue = i * 2;
                  processed.add(processedValue);
                }
              };
          Thread thread = new Thread(runnable);
          thread.start();
        });

    while (processed.isEmpty()) {
      System.out.println("Waiting for processing to complete");
    }

    return processed;
  }

  private static void delay() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
