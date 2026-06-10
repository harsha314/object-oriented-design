package com.book.booking.system.v1;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Screening {
    private Room room;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Movie movie;

    public Screening(Movie movie, Room room, LocalDateTime startTime, LocalDateTime endTime) {
        this.movie = movie ;
        this.room = room ;
        this.startTime = startTime ;
        this.endTime = endTime ;
    }

    public Duration getDuration() {
        return Duration.between(startTime, endTime);
    }
}
