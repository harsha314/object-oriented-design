package com.questions.androidunlockpattern;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.questions.androidunlockpattern.PatternHasher.Hashed;

public class PatternHasherTest {

  Logger log = LoggerFactory.getLogger(getClass());

  @Test
  void testHash() {
    try {
      Hashed hashInfo = PatternHasher.hash(List.of(1, 2, 3, 6, 9));
      assertNotNull(hashInfo);
      assertNotEquals("", hashInfo.saltBase64());
      assertNotEquals("", hashInfo.hashBase64());
    } catch (Exception e) {
      // TODO: handle exception
      log.error("testHash exception occured : ", e);
    }
  }

  @Test
  void testVerifyTrue() {
    try {
      Hashed hashInfo = PatternHasher.hash(List.of(1, 2, 3, 6, 9));
      String saltBase64 = hashInfo.saltBase64();
      String hashBase64 = hashInfo.hashBase64();

      boolean result = PatternHasher.verify(List.of(1, 2, 3, 6, 9), saltBase64, hashBase64);
      assertTrue(result);
    } catch (Exception e) {
      // TODO: handle exception
      log.error("testVerifyTrue exception occured : {} ", e);
    }
  }

  @Test
  void testVerifyFalse() {
    try {
      Hashed hashInfo = PatternHasher.hash(List.of(1, 2, 3, 9, 6));
      String saltBase64 = hashInfo.saltBase64();
      String hashBase64 = hashInfo.hashBase64();

      boolean result = PatternHasher.verify(List.of(1, 2, 3, 6, 9), saltBase64, hashBase64);
      assertFalse(result);
    } catch (Exception e) {
      // TODO: handle exception
      log.error("testVerifyTrue exception occured : {} " + e);
    }
  }
}
