package com.book.booking.system.v1;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Cinema {
    private List<Room> rooms;
    private String location;
    private String name;

    public Cinema(String name, String location) {
        this.name = name ;
        this.location = location ;
        this.rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        this.rooms.add(room) ;
    }
}
