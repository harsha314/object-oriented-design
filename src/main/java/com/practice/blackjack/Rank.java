package com.practice.blackjack;

public enum Rank {



    ACE(new int[]{}),
    TWO(new int[]{2}),
    THREE(new int[]{3}),
    FOUR(new int[]{4}),
    FIVE(new int[]{5}),
    SIX(new int[]{6}),
    SEVEN(new int[]{7}),
    EIGHT(new int[]{8}),
    NINE(new int[]{9}),

    TEN(new int[]{10}),
    JACK(new int[]{11}),
    QUEEN(new int[]{12}),
    KING(new int[]{13}),
    ;

    private final int[] values;
    Rank(int[] values) {
        this.values = values;
    }

    public int[] getValue() {
        return values;
    }

}
