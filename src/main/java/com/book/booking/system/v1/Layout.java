package com.book.booking.system.v1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class Layout {
    private int rows, columns ;
    private Map<String, Seat> seatsByNumber ;
    private final Map<Integer, Map<Integer, Seat>> seatsByPosition ; 

    public Layout(int rows, int columns) {
        this.rows = rows ;
        this.columns = columns ;
        this.seatsByNumber = new HashMap<>();
        this.seatsByPosition = new HashMap<>();
        initializeLayout();
    }

    private void initializeLayout() {
        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j < columns; ++j) {
                String seatNumber = i + "-" + j ;
                addSeat(seatNumber, i, j, new Seat(seatNumber, null));
            }
        }
    }

    public void addSeat(String seatNumber, int row, int column, Seat seat) {
        seatsByNumber.put(seatNumber, seat) ;
        seatsByPosition
            .computeIfAbsent(row, k -> new HashMap<>())
            .put(column, seat) ;
    }

    public Seat getSeatByPosition(int row, int column) {
        // return seatsByPosition
        return seatsByPosition
            .getOrDefault(rows, new HashMap<>())
            .get(column);
    }

    public List<Seat> getAllSeats() {
        return List.copyOf(seatsByNumber.values());
    }
}
