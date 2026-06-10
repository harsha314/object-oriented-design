package com.book.booking.system.v1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BookingSystem {
    private final List<Movie> movies;
    private final List<Cinema> cinemas;
    private final ScreeningManager screeningManager ;

    public BookingSystem() {
        this.movies = new ArrayList<>();
        this.cinemas = new ArrayList<>();
        this.screeningManager = new ScreeningManager();
    }

    public void addMovie(Movie movie) {
        this.movies.add(movie) ;
    }

    public void addCinema(Cinema cinema) {
        this.cinemas.add(cinema);
    }

    public void addScreening(Movie movie, Screening screening) {
        screeningManager.addScreening(movie, screening);
    }

    public void bookTicket(Screening screening, Seat seat) {
        BigDecimal price = seat.getPricingStrategy().getPrice() ;
        Ticket ticket = new Ticket(screening, seat, price);
        screeningManager.addTicket(screening, ticket);
    }
    
    public List<Screening> getShowsForMovie(Movie movie) {
        return screeningManager.getScreeningsForMovie(movie) ;
    }

    public List<Seat> getAvailableSeats(Screening screening) {
        return screeningManager.getAvailableSeats(screening);
    }

    public int getTicketCount(Screening screening) {
        return screeningManager.getTicketsForScreening(screening).size() ;
    }

    public List<Ticket> getTicketsForScreening(Screening screening) {
        return screeningManager.getTicketsForScreening(screening);
    }
}
