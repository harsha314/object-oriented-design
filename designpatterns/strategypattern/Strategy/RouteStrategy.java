package designpatterns.strategypattern.Strategy;

import java.util.List;

public interface RouteStrategy {
  public List<Integer> buildRoute(int v1, int v2);
}
