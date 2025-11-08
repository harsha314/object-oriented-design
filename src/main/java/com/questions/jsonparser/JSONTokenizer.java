package com.questions.jsonparser;

public class JSONTokenizer {

  private String input;
  private int index = 0;

  public JSONTokenizer(String input) {
    this.input = input;
  }

  public Token nextToken() {
    this.skipWhiteSpace();
    if (index > input.length())
      return new Token(TokenType.EOF, null);
    char ch = input.charAt(index);
    switch (ch) {
      case '[':
        return new Token(TokenType.LEFT_BRACKET, "[");
      case ']':
        return new Token(TokenType.RIGHT_BRACKET, "]");
      case '{':
        return new Token(TokenType.LEFT_CURLY_BRACKET, "{");
      case '}':
        return new Token(TokenType.RIGHT_CURLY_BRACKET, "}");
      case ':':
        return new Token(TokenType.COLON, ":");
      case ',':
        return new Token(TokenType.COMMA, ",");
      case '"':
        return readString();
      default:
        if (Character.isDigit(ch) || ch == '-')
          return readNumber();
        if (startsWith("true")) {
          index += 4;
          return new Token(TokenType.BOOLEAN, "true");
        }
        if (startsWith("false")) {
          index += 5;
          return new Token(TokenType.BOOLEAN, "false");
        }
        if (startsWith("null")) {
          index += 4;
          return new Token(TokenType.NULL, "null");
        }
        throw new RuntimeException("Unexpected character");
    }
  }

  private void skipWhiteSpace() {
    while (index < input.length() && Character.isWhitespace(input.charAt(index)))
      ++index;
  }

  private Token readString() {
    ++index;
    StringBuilder sb = new StringBuilder();
    while (index < input.length() && input.charAt(index) != '"') {
      sb.append(input.charAt(index));
      ++index;

    }
    ++index;
    return new Token(TokenType.STRING, sb.toString());
  }

  private Token readNumber() {
    StringBuilder sb = new StringBuilder();
    while (index < input.length()
        && (Character.isDigit(input.charAt(index)) || input.charAt(index) == '-' || input.charAt(index) == '.')) {
      sb.append(input.charAt(index));
      ++index;
    }
    return new Token(TokenType.NUMBER, sb.toString());
  }

  private boolean startsWith(String keyword) {
    return input.startsWith(keyword, index);
  }
}
