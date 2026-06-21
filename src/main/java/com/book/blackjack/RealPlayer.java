package com.book.blackjack;

public class RealPlayer implements Player {

    public final String name;
    public int balance;
    public int bet;
    public Hand hand;

    public RealPlayer(String name, int startBalance) {
        this.name = name;
        this.balance = startBalance;
        this.bet = 0;
        this.hand = new Hand();
    }

    @Override
    public void bet(int bet) {
        if(bet > balance) {
            throw new IllegalArgumentException("Bet cant be more than balance");
        }
        this.bet = bet;
        this.balance -= bet;
    }

    @Override
    public void loseBet() {
        System.out.println("Player " + name + "lost " + bet + " with card value " + hand.getPossibleValues().last());
        this.bet = 0;
    }

    @Override
    public void returnBet() {
        this.balance += this.bet;
        this.bet = 0;
    }

    @Override
    public void payout() {
        this.balance += this.bet * 2;
        this.bet = 0;
    }

    @Override
    public boolean isBust() {
        return hand.isBust();
    }

    @Override
    public Hand getHand() {
        return hand;
    }

    @Override
    public int getBalance() {
        return this.balance;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBet() {
        return this.bet;
    }
    
}
