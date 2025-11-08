package com.questions.jsonparser;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JSONParser {

  private JSONTokenizer jsonTokenizer;
  private Token current;

  public Object parse(String input) {
    return null;
  }

  private Object parseValue() {
    TokenType type = current.getTokenType();
    switch (type) {
      case LEFT_BRACKET:

        break;

      default:
        break;
    }
    return null;
  }

  private Map<String, Object> parseObject() {
    Map<String, Object> map = new LinkedHashMap<>();
    expect(TokenType.LEFT_BRACKET);
    return map;
  }

  private List<Object> parseArray() {
    return null;
  }

  private void expect(TokenType type) {
    if (current.getTokenType() != type) {
      throw new RuntimeException("");
    }
  }
}
