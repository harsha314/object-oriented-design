package com.questions.onlinemovieticketbookingsystem;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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

class BookingService {
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

class ShowService {
  List<Show> shows;

  public List<Movie> getMovies(String cityName) {
    return this.shows.stream().filter(show -> show.hall.city.name.equals(cityName)).map(show -> show.movie).toList();
  }

  public List<Show> getHalls(String cityName, String movieName) {
    City city = new City(cityName);
    return this.shows.stream().filter(show -> show.hall.city.equals(city) && show.movie.name.equals(movieName))
        .toList();
  }
}

class City {
  String name;

  public City(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }
};

class Movie {
  String name;
}

enum BookingStatus {
  AVAILABLE, LOCKED, BOOKED
};

class Show {
  Movie movie;
  Hall hall;
  Map<Seat, BookingStatus> seats = new ConcurrentHashMap<>();
}

class Hall {
  String name;
  City city;

  public City getCity() {
    return this.city;
  }
}

class Seat {
  String id;
  Double price;
}

enum State {
  INIT, PENDING, SUCCESSFUL, ABORTED
};

class PaymentsService {
  private State state = State.INIT;

}