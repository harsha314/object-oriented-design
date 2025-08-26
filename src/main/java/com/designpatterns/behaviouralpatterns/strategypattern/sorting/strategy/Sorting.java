package com.designpatterns.behaviouralpatterns.strategypattern.sorting.strategy;

import java.util.List;

public interface Sorting<T> {
  public void sort(List<T> list);
}
