package org.codingdojo.yatzy1.scoring.strategies;

import org.codingdojo.yatzy1.scoring.dice.Roll;

/**
 * A {@code ScoringStrategy} calculates the score of a {@link Roll}
 * for a specific category.
 * The rules to apply and the exact logic to use vary depending
 * on the concrete implementation.
 */
public interface ScoringStrategy {

    /**
     * @return the sum of the dice in the specified {@link Roll}
     */
    int getSum(Roll roll);

}
