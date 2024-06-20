package org.codingdojo.yatzy1.scoring.strategies.impl;

import org.codingdojo.yatzy1.scoring.dice.Roll;
import org.codingdojo.yatzy1.scoring.strategies.ScoringStrategy;

/**
 * This {@link ScoringStrategy} scores 15 points if the specified
 * {@link Roll} reads {1,2,3,4,5}; zero otherwise.
 */
public class SmallStraightStrategy implements ScoringStrategy {

    @Override
    public int getScore(Roll roll) {
        return roll.getLowestDie() == 1 && roll.isSequential() ? 15 : 0;
    }

}
