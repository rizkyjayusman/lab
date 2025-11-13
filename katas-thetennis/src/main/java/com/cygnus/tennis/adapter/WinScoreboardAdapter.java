package com.cygnus.tennis.adapter;

import com.cygnus.tennis.entity.Player;

import static com.cygnus.tennis.util.ScoreUtil.subtractPlayerScore;

public class WinScoreboardAdapter extends ScoreboardAdapter {
    public WinScoreboardAdapter(Player playerOne, Player playerTwo) {
        super(playerOne, playerTwo);
    }

    @Override
    public String getScore() {
        StringBuilder score = new StringBuilder();
        int minusResult = subtractPlayerScore(getPlayerOne(), getPlayerTwo());
        if (minusResult >= 2) {
            score.append("Win for ").append(getPlayerOne().getName());
        } else if (minusResult <= -2) {
            score.append("Win for ").append(getPlayerTwo().getName());
        }

        return score.toString();
    }
}
