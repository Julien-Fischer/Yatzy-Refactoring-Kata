package org.codingdojo.yatzy1;

import org.codingdojo.yatzy1.scoring.ScoreComputer;
import org.codingdojo.yatzy1.scoring.dice.ImmutableRoll;
import org.codingdojo.yatzy1.scoring.dice.Roll;
import org.codingdojo.yatzy1.scoring.strategies.CategoryName;
import org.codingdojo.yatzy1.scoring.strategies.factories.CacheableStrategyFactory;

public class Yatzy1 {

    public static void main(String[] args) {
        // the scoring system is now fully refactored and can be consumed
        // through the ScoreComputer
        var scoreComputer = new ScoreComputer(CacheableStrategyFactory.getInstance());
        Roll roll = new ImmutableRoll(1, 2, 3, 4, 5);
        var desiredCategory = CategoryName.SMALL_STRAIGHT;
        int score = scoreComputer.getScore(roll, desiredCategory);
        print(roll, desiredCategory, score);

        // Although the game logic itself is outside the scope of this kata,
        // we would probably encapsulate it in a Game class that takes two
        // dependencies: the ScoreComputer we just designed, and a PRNG/TRNG
        // that is responsible for generating the die throws.
    }

    private static void print(Roll roll, CategoryName name, int score) {
        final String separator = "-".repeat(10);
        System.out.println(separator);
        System.out.println("Die throw: " + roll + " scored: " + score + " points for : " + name);
        System.out.println(separator);
    }

}



