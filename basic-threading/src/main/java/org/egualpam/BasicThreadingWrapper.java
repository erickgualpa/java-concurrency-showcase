package org.egualpam;

import static java.util.stream.IntStream.range;

class BasicThreadingWrapper {

  public void runBlocking() {
    range(0, 10).forEach(this::expensiveTask);
  }

  public void runNonBlocking() {
    range(0, 10)
        .forEach(
            i -> {
              Runnable runnable = () -> expensiveTask(i);
              Thread thread = new Thread(runnable);
              thread.start();
            });
  }

  private void expensiveTask(int i) {
    try {
      Thread.sleep(200);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    System.out.println("Thread: " + i + " " + Thread.currentThread().getName());
  }
}
