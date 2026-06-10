package com.book.booking.system.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ScreeningManager {
    private Map<Movie, List<Screening>> screeningsByMovie;
    private Map<Screening, List<Ticket>> ticketsByScreening;

    public void addScreening(Movie movie, Screening screening) {
        this.screeningsByMovie
            .computeIfAbsent(movie, (mv) -> new ArrayList<>()).add(screening);
    }

    public void addTicket(Screening screening, Ticket ticket) {
        this.ticketsByScreening
            .get(screening)
            .add(ticket);
    }

    public List<Screening> getScreeningsForMovie(Movie movie) {
        return this.screeningsByMovie
            .getOrDefault(movie, new ArrayList<>()) ;
    }

    public List<Ticket> getTicketsForScreening(Screening screening) {
        return ticketsByScreening
            .getOrDefault(screening, new ArrayList<>());
    }

    public List<Seat> getAvailableSeats(Screening screening) {
        return this.ticketsByScreening
            .get(screening)
            .stream()
            .map(Ticket::getSeat)
            .toList() ;
    }



}
