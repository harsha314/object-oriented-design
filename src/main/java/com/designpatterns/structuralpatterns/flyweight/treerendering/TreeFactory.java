package com.designpatterns.structuralpatterns.flyweight.treerendering;

import java.util.HashMap;
import java.util.Map;

public class TreeFactory {
  private static final Map<String, TreeType> treeTypes = new HashMap<>();

  public static TreeType getTreeType(String name, String texture, String mesh) {
    String key = name + texture + mesh;
    return treeTypes.computeIfAbsent(key, k -> new TreeType(name, texture, mesh));
  }
}
