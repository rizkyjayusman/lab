package com.cygnus.tennis.adapter;

import com.cygnus.tennis.entity.Player;

public class DrawScoreboardAdapter extends ScoreboardAdapter {
    public DrawScoreboardAdapter(Player playerOne, Player playerTwo) {
        super(playerOne, playerTwo);
    }

    @Override
    public String getScore() {
        String description = "";
        switch(getPlayerOne().getScore())
        {
            case 0:
                description = "Love-All";
                break;
            case 1:
                description = "Fifteen-All";
                break;
            case 2:
                description = "Thirty-All";
                break;
            default:
                description = "Deuce";
                break;
        }

        return description;
    }
}
