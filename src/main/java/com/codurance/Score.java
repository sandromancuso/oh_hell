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
        Map.Entry<Player, Card> entry = null;
        return cardsPlayed
                    .entrySet()
                    .stream()
                    .reduce(entry, (e1, e2) -> e1.getValue().rank()
                                                    .compareTo(e2.getValue().rank()) > 0 ? e1 : e2)
                    .getKey();
    }

    private void initialiseScoringFor(Players players) {
        players.asList().forEach(p -> scoring.put(p, 0));
    }

}
