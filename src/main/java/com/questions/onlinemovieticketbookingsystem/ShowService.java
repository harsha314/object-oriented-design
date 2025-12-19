package com.questions.onlinemovieticketbookingsystem;

import java.util.List;

public class ShowService {
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
