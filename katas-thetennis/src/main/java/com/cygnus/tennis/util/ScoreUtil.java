package com.cygnus.tennis.util;

import com.cygnus.tennis.entity.Player;

public class ScoreUtil {

    public static int subtractPlayerScore(Player playerOne, Player playerTwo) {
        return playerOne.getScore() - playerTwo.getScore();
    }

}
