package com.codurance;

import java.util.HashMap;
import java.util.Map;

public class Score {

    private Map<Player, Integer> scoring = new HashMap<>();
    private Players players;

    public Score(Players players) {
        this.players = players;
        initialiseScoringFor(players);
    }

    public int forPlayer(Player player) {
        return -100000;
    }

    public void compute(Map<Player, Integer> bids,
                        Map<Player, Card> cardsPlayed) {
        Player winner = playerWithHighestCard(cardsPlayed);
        System.out.println(winner);
    }

    private Player playerWithHighestCard(Map<Player, Card> cardsPlayed) {
        Map.Entry<Player, Card> entryWithHighestCard = cardsPlayed.entrySet().iterator().next();
        return cardsPlayed
                    .entrySet()
                    .stream()
                    .reduce(entryWithHighestCard, (e1, e2) -> entryWithHigherCard(e1, e2))
                    .getKey();
    }

    private Map.Entry<Player, Card> entryWithHigherCard(Map.Entry<Player, Card> e1, Map.Entry<Player, Card> e2) {
        return e1.getValue().rank().greaterThan(e2.getValue().rank()) ? e1 : e2;
    }

    private void initialiseScoringFor(Players players) {
        players.asList().forEach(p -> scoring.put(p, 0));
    }

}
