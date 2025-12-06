package com.questions.androidunlockpattern;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.questions.androidunlockpattern.PatternHasher.Hashed;
import com.questions.androidunlockpattern.PatternStore.LockInfo;
import com.questions.androidunlockpattern.PatternStore.PatternInfo;

public class PatternService {
  public enum RESULT {
    SUCCESS, INVALID, MATCHED, LOCKED, TOO_SHORT
  }

  private final PatternStore store;

  public PatternService(PatternStore store) {
    this.store = store;
  }

  public void setPattern(String userId, List<Integer> points) {
    try {
      Hashed hashInfo = PatternHasher.hash(points);
      store.savePattern(null, hashInfo.saltBase64(), hashInfo.hashBase64());
    } catch (Exception e) {
      System.out.println("setPattern exception occured : " + e.getMessage());
    }
  }

  public boolean verifyPattern(String userId, List<Integer> points) {
    try {
      PatternInfo patternInfo = store.getPatternInfo(userId).get();
      LockInfo lockInfo = store.getAttempts(userId);
      boolean result = PatternHasher.verify(points, patternInfo.saltBase64(), patternInfo.hashBase64());
      store.saveAttempts(userId, lockInfo.attempts() + 1, 0);
      return result;
    } catch (Exception e) {
      System.out.println("verifyPattern exception occured : " + e.getMessage());
      return false;
    }
  }
}
