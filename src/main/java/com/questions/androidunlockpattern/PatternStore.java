package com.questions.androidunlockpattern;

import java.util.Optional;

public interface PatternStore {
  public static record PatternInfo(String saltBase64, String hashBase64) {
  }

  public static record LockInfo(int attempts, long lockedUntilMilliseconds) {
  }

  void savePattern(String userId, String saltBase64, String hashBase64);

  Optional<PatternInfo> getPatternInfo(String userId);

  void deletePattern(String userId);

  void saveAttempts(String userId, int attempts, long lockedUntilMilliseconds);

  LockInfo getAttempts(String userId);
}
