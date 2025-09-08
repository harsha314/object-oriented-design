package com.designpatterns.structuralpatterns.proxy.database;

public class Demo {
  public static void main(String[] args) {
    User adminUser = new User("admin", "ADMIN");
    User normalUser1 = new User("user1", "USER");
    User normalUser2 = new User("user2", "USER");

    DatabaseAccess adminDb = new Databaseproxy(adminUser);
    DatabaseAccess user1Db = new Databaseproxy(normalUser1);
    DatabaseAccess user2Db = new Databaseproxy(normalUser2);

    System.out.println("=".repeat(50));
    System.out.println("Testing Admin Access");
    System.out.println("Reading user1's data: " + adminDb.getUserData("user1"));
    System.out.println("Reading user2' data: " + adminDb.getUserData("user2"));
    adminDb.setUserData("user1", "updated user1's data");
    System.out.println("=".repeat(50));

    System.out.println("Testing User1 Access");
    System.out.println("Reading own data: " + user1Db.getUserData("user1"));
    System.out.println("Attempting to read user2's data: " + user1Db.getUserData("user2"));
    user1Db.setUserData("user1", "user1 updated data");
    System.out.println("=".repeat(50));

    System.out.println("Testing User2 Access");
    System.out.println("Reading own data: " + user2Db.getUserData("user2"));
    System.out.println("Attempting to read user1's data: " + user1Db.getUserData("user1"));
    user2Db.setUserData("user2", "user2 updated data");
    System.out.println("=".repeat(50));
  }
}
