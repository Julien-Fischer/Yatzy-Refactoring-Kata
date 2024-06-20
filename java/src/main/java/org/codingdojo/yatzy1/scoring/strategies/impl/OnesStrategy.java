package org.codingdojo.yatzy1.scoring.strategies.impl;

import org.codingdojo.yatzy1.scoring.dice.Roll;
import org.codingdojo.yatzy1.scoring.strategies.ScoringStrategy;

/**
 * This {@link ScoringStrategy} scores the sum of the dice that read one.
 * Examples:
 * - {1,1,2,4,4} -> 2
 * - {1,1,1,1,4} -> 4
 * - {2,3,2,4,4} -> 0
 *
 * @see <a href="https://sammancoaching.org/kata_descriptions/yatzy.html">Ones Kata Rules</a>
 */
public class OnesStrategy implements ScoringStrategy {

    private static final int DIE_VALUE = 1;

    @Override
    public int getScore(Roll roll) {
        return (int) roll.getDice().stream()
            .filter(die -> die == DIE_VALUE)
            .count() * DIE_VALUE;
    }

}
