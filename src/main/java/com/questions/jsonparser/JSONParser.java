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
      case LEFT_CURLY_BRACKET:
        return parseObject();

      default:
        break;
    }
    return null;
  }

  private Map<String, Object> parseObject() {
    Map<String, Object> map = new LinkedHashMap<>();
    expect(TokenType.LEFT_CURLY_BRACKET);

    if (current.getTokenType() == TokenType.RIGHT_CURLY_BRACKET) {
      jsonTokenizer.nextToken();
      return map;
    }
    do {
      expect(TokenType.STRING);
      String key = current.getContent();
      current = jsonTokenizer.nextToken();

      expect(TokenType.COLON);
      current = jsonTokenizer.nextToken();
      Object value = parseValue();
      map.put(key, value);
      if (current.getTokenType() == TokenType.COMMA) {
        current = jsonTokenizer.nextToken();
      } else
        break;
    } while (true);
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
