package org.egualpam;

import static java.util.stream.IntStream.range;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BasicThreadingWithCollectionsTest {

  private BasicThreadingWithCollections testSubject;

  @BeforeEach
  void setUp() {
    testSubject = new BasicThreadingWithCollections();
  }

  @Test
  void run() {
    Set<Integer> datasource = range(0, 10000).boxed().collect(Collectors.toSet());

    Instant start = Instant.now();
    Set<Integer> result = testSubject.run(datasource);
    Instant end = Instant.now();
    printTimeElapsed(end, start);

    assertEquals(1, result.size());
    assertEquals(Set.of(100), result);
  }

  private static void printTimeElapsed(Instant end, Instant start) {
    System.out.println("Time elapsed: " + (end.toEpochMilli() - start.toEpochMilli()) + "ms");
  }
}
