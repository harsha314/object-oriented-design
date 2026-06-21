package com.book.blackjack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Hand {
    final List<Card> handCards = new ArrayList<>();

    final SortedSet<Integer> possibleValues = new TreeSet<>();

    public Hand() {}

    public void addCard(Card card) {
        if(card == null) {
            
            return;
        }
        handCards.add(card);
        if(possibleValues.isEmpty()) {
            for(int value : card.getRankValues()) {
                possibleValues.add(value) ;
            }
        } else {
            SortedSet<Integer> newPossibleValues = new TreeSet<>();
            for(int cardValue : card.getRankValues()) {
                for(int value : possibleValues) {
                    newPossibleValues.add(cardValue + value);
                }
            }
            possibleValues.clear();
            possibleValues.addAll(newPossibleValues);
        }
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(handCards);
    }

    public SortedSet<Integer> getPossibleValues() {
        return Collections.unmodifiableSortedSet(possibleValues);
    }

    public void clear() {
        handCards.clear();
        possibleValues.clear();
    }

    public boolean isBust() {
        if(possibleValues.isEmpty()) {
            return false;
        } else {
            return possibleValues.first() > 21;
        }
    }
}
