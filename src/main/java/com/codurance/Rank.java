package com.codurance;

public enum Rank {

    SIX, SEVEN, EIGHT, NINE;

    public boolean greaterThan(Rank rank) {
        return this.ordinal() > rank.ordinal();
    }



}
