package com.designpatterns.strategypattern.sorting.strategy;

import java.util.Comparator;
import java.util.List;

public class MergeSorting<T extends Comparable<? super T>> implements Sorting<T> {
  private final Merger<T> merger;

  public MergeSorting() {
    this.merger = new Merger<>();
  }

  @Override
  public void sort(List<T> list) {
    if (list == null || list.isEmpty()) {
      return;
    }
    mergeSort(list, Comparator.naturalOrder(), 0, list.size() - 1);
  }

  private void mergeSort(List<T> list, Comparator<T> comparator, int left, int right) {
    if (left < right) {
      int middle = left + (right - left) / 2; // Prevents integer overflow
      mergeSort(list, comparator, left, middle);
      mergeSort(list, comparator, middle + 1, right);
      merger.merge(list, comparator, left, middle, right);
    }
  }
}