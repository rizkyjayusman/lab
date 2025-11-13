package com.cygnus.tennis.adapter;

import com.cygnus.tennis.entity.Player;

public abstract class ScoreboardAdapter {

    private final Player playerOne;
    private final Player playerTwo;

    public ScoreboardAdapter(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public abstract String getScore();
}
