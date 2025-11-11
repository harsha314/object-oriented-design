package com.questions.jsonparser;

import java.util.ArrayList;
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
      case LEFT_BRACKET:
        return parseArray();
      case STRING:
        String s = current.getContent();
        return s;
      case NUMBER:
        double num = Double.parseDouble(current.getContent());
        return num;
      case BOOLEAN:
        boolean value = Boolean.parseBoolean(current.getContent());
        return value;
      case NULL:
        current = jsonTokenizer.nextToken();
        return null;
      default:
        throw new RuntimeException("Unexpected token" + current.getTokenType());
    }
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
    List<Object> list = new ArrayList<>();
    expect(TokenType.LEFT_BRACKET);

    if (current.getTokenType() == TokenType.RIGHT_BRACKET) {
      jsonTokenizer.nextToken();
      return list;
    }
    do {
      list.add(parseValue());
      if (current.getTokenType() == TokenType.COMMA) {
        current = jsonTokenizer.nextToken();
      } else
        break;
    } while (true);
    return list;
  }

  private void expect(TokenType type) {
    if (current.getTokenType() != type) {
      throw new RuntimeException("");
    }
  }
}
