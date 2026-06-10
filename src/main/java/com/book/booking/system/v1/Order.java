package com.book.booking.system.v1;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Order {
    private List<Ticket> tickets;
    private LocalDateTime orderDate;

    public Order(LocalDateTime orderDate) {
        this.orderDate = orderDate ;
        this.tickets = new ArrayList<>();
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket) ;
    }
    public BigDecimal calculateTotalPrice() {
        return this.tickets
            .stream()
            .map(Ticket::getPrice)
            .reduce(BigDecimal.ZERO, (price, ticket) -> price.add(ticket)) ;
    }
}
