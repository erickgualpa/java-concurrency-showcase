package org.egualpam;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class ConcurrentCollectionsSimpleExampleTest {

  private ConcurrentCollectionsSimpleExample testSubject;

  @BeforeEach
  void setUp() {
    testSubject = new ConcurrentCollectionsSimpleExample();
  }

  @RepeatedTest(50)
  void processUsingRegularCollection() {
    Instant start = Instant.now();
    List<Integer> result = testSubject.processUsingRegularCollection(10);
    Instant end = Instant.now();
    printTimeElapsed(end, start);

    assertEquals(10, result.size());
    System.out.println("Result: " + result);
  }

  private static void printTimeElapsed(Instant end, Instant start) {
    System.out.println("Time elapsed: " + (end.toEpochMilli() - start.toEpochMilli()) + "ms");
  }
}
