package com.questions.onlinemovieticketbookingsystem;

public class Seat {
  String id;
  Double price;

  public Seat(String id, Double price) {
    this.id = id;
    this.price = price;
  }

  public String getId() {
    return this.id;
  }

  public Double getPrice() {
    return this.price;
  }
}
