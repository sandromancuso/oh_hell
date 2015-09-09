package com.codurance;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private final Players players;
    private final Deck deck;
    private Score score;

    private Map<Player, Integer> bids = new HashMap<>();
    private Map<Player, Card> cardsPlayed = new HashMap<>();

    public Game(Players players, Deck deck, Score score) {
        this.players = players;
        this.deck = deck;
        this.score = score;
    }

    public void newTurn() {
        // distribute cards to players
        players.asList()
                .forEach(player -> player.receiveCards(deck.nextCard()));

        // players bid
        players.asList()
                .forEach(player -> bids.put(player, player.bid()));

        // players show cards
        players.asList()
                .forEach(player -> cardsPlayed.put(player, player.showCard()));

        // score is calculated
        score.compute(bids, cardsPlayed);
    }
}
