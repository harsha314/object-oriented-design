package com.questions.androidunlockpattern;

public class PatternStore {
  private String hashedPattern;

  public PatternStore(PatternHasher patternHasher) {
    // this.patternHasher = patternHasher;
  }

  public void store(Pattern pattern) {

  }

  public boolean verifyPattern(Pattern pattern) {
    return false;
  }
}
