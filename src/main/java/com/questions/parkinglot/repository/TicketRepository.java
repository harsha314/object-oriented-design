package com.questions.parkinglot.repository;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import com.questions.parkinglot.model.Ticket;

public class TicketRepository {
  private Map<String, Ticket> tickets = new HashMap<>();

  public Ticket getTicket(String ticketId) {
    return tickets.get(ticketId);
  }

  public Ticket setTicketExitTime(String ticketId, Instant exitTime) {
    Ticket ticket = tickets.get(ticketId);
    ticket.setExitTime(exitTime);
    return ticket;
  }
}
