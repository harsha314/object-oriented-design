package com.book.booking.system.v1;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Seat {
    private String id;
    private PricingStrategy pricingStrategy;

    public BigDecimal getPrice() {
        return this.pricingStrategy.getPrice() ;
    }
}
