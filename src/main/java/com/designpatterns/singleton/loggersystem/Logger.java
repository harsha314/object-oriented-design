package com.designpatterns.singleton.loggersystem;

public class Logger {

  private Logger logger;

  private Logger() {

  }

  public Logger getInstance() {
    if (this.logger == null) {
      this.logger = new Logger();
    }
    return this.logger;
  }

  public void debug(String message) {
    System.out.println(message);
  }

  public void info(String message) {
    System.out.println(message);

  }

  public void warn(String message) {
    System.out.println(message);

  }

  public void error(String message) {
    System.out.println(message);

  }
}