package com.cygnus.tennis.policy;

import com.cygnus.tennis.entity.Player;

import static com.cygnus.tennis.util.ScoreUtil.subtractPlayerScore;
import static java.lang.Math.abs;

public class ScorePolicy {

    public static boolean isDrawScore(Player playerOne, Player playerTwo) {
        return playerOne.getScore() == playerTwo.getScore();
    }

    public static boolean isDefaultScore(Player playerOne, Player playerTwo) {
        return isScoreEqualOrMoreThanZeroAndEqualOrMoreThanThree(playerOne.getScore()) && isScoreEqualOrMoreThanZeroAndEqualOrMoreThanThree(playerTwo.getScore());
    }

    public static boolean isScoreEqualOrMoreThanZeroAndEqualOrMoreThanThree(int score) {
        return score >= 0 && score <= 3;
    }

    public static boolean isAdvantageScore(Player playerOne, Player playerTwo) {
        int result = subtractPlayerScore(playerOne, playerTwo);
        return isScoreEqualOrMoreThanFour(playerOne, playerTwo) && abs(result) == 1;
    }

    public static boolean isWinScore(Player playerOne, Player playerTwo) {
        int result = subtractPlayerScore(playerOne, playerTwo);
        return isScoreEqualOrMoreThanFour(playerOne, playerTwo) && abs(result) >= 2;
    }

    public static boolean isScoreEqualOrMoreThanFour(Player playerOne, Player playerTwo) {
        return playerOne.getScore() >= 4 || playerTwo.getScore() >= 4;
    }
}
