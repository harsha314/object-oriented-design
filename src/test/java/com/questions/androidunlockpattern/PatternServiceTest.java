package com.questions.androidunlockpattern;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import com.questions.androidunlockpattern.PatternHasher.Hashed;

public class PatternServiceTest {
  @Test
  void testSetPattern() {
    PatternStore store = mock(PatternStore.class);
    PatternService service = new PatternService(store);
    List<Integer> points = List.of(1, 2, 3, 6);

    Hashed mockedHash = new Hashed("salt123", "hash123");

    try (MockedStatic<PatternHasher> mockedStatic = mockStatic(PatternHasher.class)) {
      mockedStatic.when(() -> PatternHasher.hash(points)).thenReturn(mockedHash);
      service.setPattern("0", points);
      verify(store).savePattern(null, "salt123", "hash123");
      // verify(store).savePattern(equals(null), equals("salt123"),
      // equals("hash123"));
    }
  }

  @Test
  void testVerifyPattern() {

  }
}
