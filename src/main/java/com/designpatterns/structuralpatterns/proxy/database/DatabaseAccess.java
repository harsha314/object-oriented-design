package com.designpatterns.structuralpatterns.proxy.database;

public interface DatabaseAccess {
  String getUserData(String userId);

  void setUserData(String userId, String data);
}
