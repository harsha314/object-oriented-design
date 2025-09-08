package com.designpatterns.structuralpatterns.proxy.database;

public class Databaseproxy implements DatabaseAccess {
  private RealDatabase database;
  private User currentUser;

  public Databaseproxy(User user) {
    this.database = new RealDatabase();
    this.currentUser = user;
  }

  @Override
  public String getUserData(String userId) {
    if (!this.hasReadAccess(userId)) {
      return "Access Denied: Insufficient Permissions";
    }
    return this.database.getUserData(userId);
  }

  @Override
  public void setUserData(String userId, String data) {
    if (!this.hasWriteAccess(userId)) {
      System.out.println("Access Denied: Insufficient Permissions");
    }
    this.database.setUserData(userId, data);
  }

  private boolean hasReadAccess(String userId) {
    if ("ADMIN".equals(currentUser.getRole())) {
      return true;
    }

    return currentUser.getUserId().equals(userId);
  }

  public boolean hasWriteAccess(String userId) {
    return "ADMIN".equals(currentUser.getRole());
  }
}
