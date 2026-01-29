package com.questions.splitwise.repository;

import java.util.HashMap;
import java.util.Map;

import com.questions.splitwise.model.User;

public class UserRepository {
  private Map<String, User> data = new HashMap<>();

  public User getUser(String id) {
    return data.get(id);
  }

}
