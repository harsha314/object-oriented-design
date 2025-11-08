package com.questions.jsonparser;

public class Token {
  private TokenType tokenType;
  private String content;

  public Token(TokenType tokenType, String content) {
    this.tokenType = tokenType;
    this.content = content;
  }

  public TokenType getTokenType() {
    return this.tokenType;
  }

  public String getContent() {
    return this.content;
  }

}
