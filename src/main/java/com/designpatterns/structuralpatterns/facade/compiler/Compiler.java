package com.designpatterns.structuralpatterns.facade.compiler;

public class Compiler {
  private final Lexer lexer;
  private final Parser parser;
  private final Optimizer optimizer;
  private final CodeGenerator codeGenerator;

  public Compiler() {
    this.lexer = new Lexer();
    this.parser = new Parser();
    this.optimizer = new Optimizer();
    this.codeGenerator = new CodeGenerator();
  }

  public String compiler(String sourceCode) {
    System.out.println("Starting compilation process");

    String tokenized = lexer.tokenize(sourceCode);
    String parsed = parser.parse(tokenized);
    String optimized = optimizer.optimize(parsed);
    String machineCode = codeGenerator.generateCode(optimized);
    return machineCode;
  }
}
