package com.questions.splitwise.model;

import lombok.Getter;

@Getter
public class User {
  private int id;
  private String name;
  private String email;

  public User(String name, String email) {
    this.name = name;
    this.email = email;
  }
}
