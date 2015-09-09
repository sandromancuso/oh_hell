package com.codurance;

import java.util.LinkedList;

import static java.util.Arrays.asList;

public class Deck {
    private LinkedList<Card> cards = new LinkedList<>();

    public Deck(Card... cards) {
        asList(cards).forEach(c -> this.cards.add(c));
    }

    public Card nextCard() {
        return cards.remove();
    }
}
