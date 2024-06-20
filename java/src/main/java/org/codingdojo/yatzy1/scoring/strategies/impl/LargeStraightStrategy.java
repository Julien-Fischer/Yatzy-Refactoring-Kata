package org.codingdojo.yatzy1.scoring.strategies.impl;

import org.codingdojo.yatzy1.scoring.dice.Roll;
import org.codingdojo.yatzy1.scoring.strategies.ScoringStrategy;

/**
 * This {@link ScoringStrategy} scores 20 points if the specified
 * {@link Roll} reads {2,3,4,5,6}; zero otherwise.
 *
 * @see <a href="https://sammancoaching.org/kata_descriptions/yatzy.html">Large straight Kata Rules</a>
 */
public class LargeStraightStrategy implements ScoringStrategy {

    @Override
    public int getScore(Roll roll) {
        return roll.getLowestDie() == 2 && roll.isSequential() ? 20 : 0;
    }

}
