package com.book.blackjack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlackJackGame {
    private final Deck deck = new Deck();
    private final List<Player> players = new ArrayList<>();
    private final Player dealerPlayer = new DealerPlayer();

    private Player currentPlayer = null;

    Map<Player, Action> playerTurnStatusMap = new HashMap<>();


    public BlackJackGame(List<Player> players) {
        for(Player player : players) {
            this.players.add(player);
            this.playerTurnStatusMap.put(player, null);
        }
        this.currentPlayer = players.get(0);
        this.playerTurnStatusMap.put(dealerPlayer, null);
        deck.shuffle();
    }

    public Player getNextEligiblePlayer() {
        if(currentPlayer != null &&
            !Action.STAND.equals(playerTurnStatusMap.get(currentPlayer)) &&
            !currentPlayer.isBust()
        ) {
            return currentPlayer;
        }

        if(currentPlayer == null) {
            for(Player player : players) {
                if(!Action.STAND.equals(playerTurnStatusMap.get(player)) && !player.isBust()) {
                    currentPlayer = player;
                    return currentPlayer;
                }
            }
        }

        int currentPlayerIndex = players.indexOf(currentPlayer);

        for(int i = currentPlayerIndex + 1; i < players.size(); ++i) {
            Player player = players.get(i);
            if(!Action.STAND.equals(playerTurnStatusMap.get(player)) && !player.isBust()) {
                if(currentPlayer == dealerPlayer) {
                    if(!Action.STAND.equals(playerTurnStatusMap.get(dealerPlayer)))
                        dealerTurn();
                    return currentPlayer;
                }
                currentPlayer = player;
                return currentPlayer;
            }
        }
        return null;
    }

    private void dealerTurn() {
        while(dealerPlayer.getHand().getPossibleValues().last() < 17) {
            Card newDraw = deck.draw();
            dealerPlayer.getHand().addCard(newDraw);
        }
        playerTurnStatusMap.put(dealerPlayer, Action.STAND);
        checkGameEndCondition();
    }

    public void startNewRound() {
        // TODO
    }

    public void dealInitialCards() {
        // TODO:
    }

    public void bet(Player player, int bet) {
        // TODO:
    }
     
    public void hit(Player player) {
        // TODO
    }

    public void stand(Player player) {
        // TODO
    }

    private void checkGameEndCondition() {
        // TODO
    }
}
