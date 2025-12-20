package com.questions.onlinemovieticketbookingsystem;

import java.util.List;

public class OnlineBookingSystem {
  private ShowService showService;
  private BookingService bookingService;

  public List<Movie> getMovies(String cityName) {
    return showService.getMovies(cityName);
  }

  public List<Show> getHalls(String cityName, String movieName) {
    return showService.getHalls(cityName, movieName);
  }

  public void orderTicket(Show show, List<Seat> ticketIds) throws Exception {
    bookingService.orderTicket(show, ticketIds);
  }

}
