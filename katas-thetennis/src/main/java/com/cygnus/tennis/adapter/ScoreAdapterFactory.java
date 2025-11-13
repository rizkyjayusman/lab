package com.cygnus.tennis.adapter;

import com.cygnus.tennis.entity.Player;

import static com.cygnus.tennis.policy.ScorePolicy.*;

public class ScoreAdapterFactory {

    public static ScoreboardAdapter getAdapter(Player playerOne, Player playerTwo) {
        ScoreboardAdapter adapter;
        if (isDrawScore(playerOne, playerTwo)) {
            adapter = new DrawScoreboardAdapter(playerOne, playerTwo);
        } else if (isAdvantageScore(playerOne, playerTwo)) {
            adapter = new AdvantageScoreboardAdapter(playerOne, playerTwo);
        } else if (isWinScore(playerOne, playerTwo)) {
            adapter = new WinScoreboardAdapter(playerOne, playerTwo);
        } else if (isDefaultScore(playerOne, playerTwo)) {
            adapter = new DefaultScoreboardAdapter(playerOne, playerTwo);
        } else {
            throw new RuntimeException("no adapter handing");
        }

        return adapter;
    }

}
