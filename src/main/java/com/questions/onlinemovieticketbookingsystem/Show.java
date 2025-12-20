package com.questions.onlinemovieticketbookingsystem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Show {
  Movie movie;
  Hall hall;
  Map<Seat, BookingStatus> seats = new ConcurrentHashMap<>();
}
