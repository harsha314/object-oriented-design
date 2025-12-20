package com.questions.onlinemovieticketbookingsystem;

import java.util.List;

public class BookingService {
  private PaymentsService paymentsService;

  public void orderTicket(Show show, List<Seat> ticketIds) throws Exception {
    for (Seat seat : ticketIds) {
      if (show.seats.get(seat) != BookingStatus.AVAILABLE) {
        throw new Exception("Seats are already bought");
      }
    }

    for (Seat seat : ticketIds) {
      show.seats.compute(seat, (k, status) -> BookingStatus.LOCKED);
    }
  }
}
