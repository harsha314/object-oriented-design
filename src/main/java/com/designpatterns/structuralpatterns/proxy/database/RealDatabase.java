package com.designpatterns.structuralpatterns.proxy.database;

import java.util.HashMap;
import java.util.Map;

public class RealDatabase implements DatabaseAccess {
  private Map<String, String> data;

  public RealDatabase() {
    this.data = new HashMap<>();
    data.put("user1", "user1's sensitive data");
    data.put("user2", "user2's sensitive data");
  }

  @Override
  public String getUserData(String userId) {
    System.out.println("Retrieving data for user : " + userId);
    return data.getOrDefault(userId, "No data found");
  }

  @Override
  public void setUserData(String userId, String userData) {
    System.out.println("Setting data for user : " + userId);
    data.put(userId, userData);
  }

}
