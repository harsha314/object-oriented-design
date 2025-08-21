package designpatterns.strategypattern.sorting.src.strategy;

import java.util.List;

public interface Sorting<T> {
  public void sort(List<T> list);
}
