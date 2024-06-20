package org.codingdojo.yatzy1.scoring.strategies.impl;

import org.codingdojo.yatzy1.scoring.dice.Roll;
import org.codingdojo.yatzy1.scoring.strategies.ScoringStrategy;

/**
 * This {@link ScoringStrategy} scores the sum of the dice that read a specified
 * value.
 * Examples:
 * - {1,1,2,4,4} scored on ones -> 2
 * - {1,1,1,1,4} scored on ones -> 4
 * - {2,3,2,4,4} scored on ones -> 0
 *
 * @see <a href="https://sammancoaching.org/kata_descriptions/yatzy.html">Ones, twos, threes, fours, fives, sixes Kata Rules</a>
 */
public abstract class AbstractNumberStrategy implements ScoringStrategy {

    private final int dieValue;

    public AbstractNumberStrategy(int dieValue) {
        this.dieValue = dieValue;
    }

    @Override
    public int getScore(Roll roll) {
        return (int) roll.getDice().stream()
            .filter(die -> die == dieValue)
            .count() * dieValue;
    }

}
