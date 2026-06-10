package com.book.booking.system.v1;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Room {
    private String roomNumber;
    private Layout layout;
}
