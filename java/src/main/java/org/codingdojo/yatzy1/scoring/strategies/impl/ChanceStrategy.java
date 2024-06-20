package org.codingdojo.yatzy1.scoring.strategies.impl;

import org.codingdojo.yatzy1.scoring.dice.Roll;
import org.codingdojo.yatzy1.scoring.strategies.ScoringStrategy;

/**
 * The player scores the sum of all dice, no matter what they read.
 *
 * @see <a href="https://sammancoaching.org/kata_descriptions/yatzy.html">Chance Kata Rules</a>
 */
public class ChanceStrategy implements ScoringStrategy {

    @Override
    public int getSum(Roll roll) {
        return roll.getSum();
    }

}
