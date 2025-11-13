package com.cygnus.tennis.adapter;

import com.cygnus.tennis.entity.Player;

public class DefaultScoreboardAdapter extends ScoreboardAdapter {

    public DefaultScoreboardAdapter(Player playerOne, Player playerTwo) {
        super(playerOne, playerTwo);
    }

    public String getScore() {
        return getScore(getPlayerOne()) + "-" + getScore(getPlayerTwo());
    }

    public String getScore(Player player) {
        String description;
        switch(player.getScore()) {
            case 0:
                description = "Love";
                break;
            case 1:
                description = "Fifteen";
                break;
            case 2:
                description = "Thirty";
                break;
            case 3:
                description = "Forty";
                break;
            default:
                throw new RuntimeException("invalid score");
        }

        return description;
    }
}
