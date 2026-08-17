package com.practice.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Hand {
    private Player player;
    private List<Card> cards;

    public Hand(Player player) {
        this.player = player;
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public Integer calculateTotal() {
        int total = 0;
        // find the most convenient value which has value between 18 to 21 inclusive
        return total;
    }

}
