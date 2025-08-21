package com.designpatterns.strategypattern.sorting.strategy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MergeSortingTest {
  private final MergeSorting<Integer> sorter = new MergeSorting<>();

  @Test
  void testEmptyList() {
    List<Integer> list = Arrays.asList();
    sorter.sort(list);
    assertTrue(list.isEmpty());
  }

  @Test
  void testSingleElement() {
    List<Integer> list = Arrays.asList(1);
    sorter.sort(list);
    assertEquals(Arrays.asList(1), list);
  }

  @Test
  void testMultipleElements() {
    List<Integer> list = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5);
    List<Integer> expected = Arrays.asList(1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9);
    sorter.sort(list);
    assertEquals(expected, list);
  }
}