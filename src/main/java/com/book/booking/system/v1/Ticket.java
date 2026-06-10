package com.book.booking.system.v1;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Ticket {
    private Screening screening;
    private Seat seat;
    private BigDecimal price;

    public Ticket(Screening screening, Seat seat, BigDecimal price) {
        this.screening = screening ;
        this.seat = seat ;
        this.price = price ;
    }



    public BigDecimal getPrice() {
        return this.price ;
    }
}
