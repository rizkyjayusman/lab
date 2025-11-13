package com.cygnus.tennis.adapter;

import com.cygnus.tennis.entity.Player;

import static com.cygnus.tennis.util.ScoreUtil.subtractPlayerScore;

public class AdvantageScoreboardAdapter extends ScoreboardAdapter {
    public AdvantageScoreboardAdapter(Player playerOne, Player playerTwo) {
        super(playerOne, playerTwo);
    }

    @Override
    public String getScore() {
        StringBuilder score = new StringBuilder();
        int minusResult = subtractPlayerScore(getPlayerOne(), getPlayerTwo());
        if (minusResult == 1) {
            score.append("Advantage ").append(getPlayerOne().getName());
        } else if (minusResult == -1) {
            score.append("Advantage ").append(getPlayerTwo().getName());
        }

        return score.toString();
    }
}
