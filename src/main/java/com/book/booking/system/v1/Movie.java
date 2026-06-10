package com.book.booking.system.v1;

import java.time.Duration;

import lombok.Data;

@Data
public class Movie {
    private String title;
    private String genre;
    private Duration duration;

    public Movie(String title, String genre, int durationInMinutes) {
        this.title = title ;
        this.genre = genre ;
        this.duration = Duration.ofMinutes(durationInMinutes) ;
    }
}
