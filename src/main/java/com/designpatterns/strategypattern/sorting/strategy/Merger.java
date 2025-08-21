package com.designpatterns.strategypattern.sorting.strategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Merger<T> {
  public void merge(List<T> list, Comparator<T> comparator, int left, int middle, int right) {
    List<T> leftList = new ArrayList<>(list.subList(left, middle + 1));
    List<T> rightList = new ArrayList<>(list.subList(middle + 1, right + 1));

    int leftIndex = 0;
    int rightIndex = 0;
    int currentIndex = left;

    while (leftIndex < leftList.size() && rightIndex < rightList.size()) {
      if (comparator.compare(leftList.get(leftIndex), rightList.get(rightIndex)) <= 0) {
        list.set(currentIndex, leftList.get(leftIndex));
        leftIndex++;
      } else {
        list.set(currentIndex, rightList.get(rightIndex));
        rightIndex++;
      }
      currentIndex++;
    }

    while (leftIndex < leftList.size()) {
      list.set(currentIndex++, leftList.get(leftIndex++));
    }

    while (rightIndex < rightList.size()) {
      list.set(currentIndex++, rightList.get(rightIndex++));
    }
  }
}