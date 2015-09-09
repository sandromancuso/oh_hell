package com.codurance;

import java.util.Arrays;

public class Player {

    private Card[] cards;

    public void receiveCards(Card... cards) {
        this.cards = cards;
    }

    public int bid() {
        throw new UnsupportedOperationException();
    }

    public Card showCard() {
        return cards[0];
    }

    @Override
    public String toString() {
        return "Player{" +
                "cards=" + Arrays.toString(cards) +
                '}';
    }
}
