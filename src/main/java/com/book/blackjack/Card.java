package com.book.blackjack;

public class Card {
    public final Rank rank;
    public final Suit suit;

    public Card(final Rank rank, final Suit suit) {
        this.rank = rank ;
        this.suit = suit ;
    }

    public int[] getRankValues() {
        return this.rank.getRankValues() ;
    }
}
