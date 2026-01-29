package com.questions.parkinglot.model;

import java.time.Instant;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Ticket {
  private String id = UUID.randomUUID().toString();
  private Instant entryTime;
  @Setter
  private Instant exitTime;
  private String spotId;

  public Ticket(String spotId) {
    this.entryTime = Instant.now();
    this.spotId = spotId;
  }

}
