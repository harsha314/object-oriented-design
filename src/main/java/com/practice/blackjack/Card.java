package com.practice.blackjack;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Card {
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

}
