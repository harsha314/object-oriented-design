package com.book.booking.system.v1;

import java.math.BigDecimal;

public interface PricingStrategy {
    BigDecimal getPrice();
}
