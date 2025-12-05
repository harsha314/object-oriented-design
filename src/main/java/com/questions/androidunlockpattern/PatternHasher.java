package com.questions.androidunlockpattern;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

public class PatternHasher {
  private static final SecureRandom secureRandom = new SecureRandom();
  private static final int ITER = 100_000;
  private static final int KEYLEN = 256;

  public static class Hashed {
    public String saltBase64;
    public String hashBase64;

    public Hashed(String s, String h) {
      this.saltBase64 = s;
      this.hashBase64 = h;
    }
  }

  public static Hashed hash(List<Integer> ids) throws Exception {
    byte[] salt = new byte[16];
    secureRandom.nextBytes(salt);
    byte[] hash = pbkdf2(ids, salt);
    return new Hashed(Base64.getEncoder().encodeToString(salt), Base64.getEncoder().encodeToString(hash));
  }

  public static boolean verify(List<Integer> ids, String saltBase64, String hashBase64) throws Exception {
    byte[] salt = Base64.getDecoder().decode(saltBase64);
    byte[] hash = Base64.getDecoder().decode(hashBase64);
    byte[] actual = pbkdf2(ids, salt);
    return MessageDigest.isEqual(hash, actual);
  }

  private static byte[] pbkdf2(List<Integer> ids, byte[] salt) throws Exception {
    String seq = ids.stream().map(String::valueOf).collect(Collectors.joining(","));
    PBEKeySpec spec = new PBEKeySpec(seq.toCharArray(), salt, ITER, KEYLEN);
    SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
    return skf.generateSecret(spec).getEncoded();
  }
}
