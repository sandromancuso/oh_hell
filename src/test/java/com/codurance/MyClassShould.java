package com.codurance;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class MyClassShould {

    private static final Card SIX_OF_HEARTS = new Card(Rank.SIX, Suit.HEARTS);
    private static final Card SEVEN_OF_HEARTS = new Card(Rank.SEVEN, Suit.HEARTS);
    private static final Card EIGHT_OF_HEARTS = new Card(Rank.EIGHT, Suit.HEARTS);
    private static final Card NINE_OF_HEARTS = new Card(Rank.NINE, Suit.HEARTS);

    Player player1;
    Player player2;
    Player player3;
    Player player4;

    private Game game;
    private Score score;

    @Before
    public void initialise() {
    }

    @Test public void
    blah() {
        Deck deck = new Deck(SIX_OF_HEARTS,
                                SEVEN_OF_HEARTS,
                                EIGHT_OF_HEARTS,
                                NINE_OF_HEARTS);

        Players players = playersBidding(0, 0, 0, 0);
        score = new Score(players);
        game = new Game(players, deck, score);

        game.newTurn();

        assertThat(score.forPlayer(player1), is(5));
        assertThat(score.forPlayer(player2), is(5));
        assertThat(score.forPlayer(player3), is(5));
        assertThat(score.forPlayer(player4), is(-1));
    }

    private Players playersBidding(int bid1, int bid2, int bid3, int bid4) {
        this.player1 = new PlayerForTest(bid1);
        this.player2 = new PlayerForTest(bid2);
        this.player3 = new PlayerForTest(bid3);
        this.player4 = new PlayerForTest(bid4);
        return new Players(player1, player2, player3, player4);
    }

    private class PlayerForTest extends Player {
        private int bid;

        public PlayerForTest(int bid) {
            this.bid = bid;
        }

        @Override
        public int bid() {
            return this.bid;
        }
    }

}