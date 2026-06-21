package com.book.blackjack;

public class DealerPlayer implements Player {

    private final String name = "DEALER";
    private final Hand hand;

    public DealerPlayer() {
        this.hand = new Hand();
    }

    @Override
    public void bet(int bet) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bet'");
    }

    @Override
    public void loseBet() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loseBet'");
    }

    @Override
    public void returnBet() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'returnBet'");
    }

    @Override
    public void payout() {
        // Dealer does not get a payout
    }

    @Override
    public boolean isBust() {
        return this.hand.isBust();
    }

    @Override
    public Hand getHand() {
        return hand;
    }

    @Override
    public int getBalance() {
        return 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBet() {
        return 0;
    }
    
}
