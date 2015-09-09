package com.codurance;

import java.util.Arrays;
import java.util.List;

public class Players {
    private Player[] players;

    public Players(Player... players) {
        this.players = players;
    }

    public List<Player> asList() {
        return Arrays.asList(players);
    }
}
