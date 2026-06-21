package com.book.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    int nextCardIndex = 0;
    List<Card> cards;

    public Deck() {
        initializeDeck();
    }

    private void initializeDeck() {
        cards = new ArrayList<>();
        for(Suit suit : Suit.values()) {
            for(Rank rank : Rank.values()) {
                Card card = new Card(rank, suit);
                cards.add(card);
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards, new Random(System.currentTimeMillis()));
    }

    public Card draw() {
        if(isEmpty()) {

        }
        Card drawCard = cards.get(nextCardIndex);
        ++nextCardIndex;
        return drawCard;
    }

    public boolean isEmpty() {
        return nextCardIndex >= cards.size();
    }

    public void reset() {
        nextCardIndex = 0;
    }
}
