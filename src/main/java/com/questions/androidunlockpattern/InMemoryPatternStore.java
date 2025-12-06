package com.questions.androidunlockpattern;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryPatternStore implements PatternStore {

  private Map<String, PatternInfo> db = new HashMap<>();
  private Map<String, LockInfo> locks = new HashMap<>();

  @Override
  public void savePattern(String userId, String saltBase64, String hashBase64) {
    this.db.put(userId, new PatternInfo(saltBase64, hashBase64));
    this.locks.put(userId, new LockInfo(0, -1));
  }

  @Override
  public Optional<PatternInfo> getPatternInfo(String userId) {
    return Optional.ofNullable(db.get(userId));
  }

  @Override
  public void deletePattern(String userId) {
    db.remove(userId);
    locks.remove(userId);
  }

  @Override
  public void saveAttempts(String userId, int attemps, long lockedUntilMilliseconds) {
    locks.put(userId, new LockInfo(attemps, lockedUntilMilliseconds));
  }

  @Override
  public LockInfo getAttempts(String userId) {
    return locks.get(userId);
  }

}
