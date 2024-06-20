package org.codingdojo.yatzy1.scoring.strategies.impl;

import org.codingdojo.yatzy1.scoring.dice.Pair;
import org.codingdojo.yatzy1.scoring.dice.Roll;
import org.codingdojo.yatzy1.scoring.strategies.ScoringStrategy;

/**
 * This {@link ScoringStrategy} scores the sum of n dice that have the
 * same number; zero otherwise.
 * The exact value to use as a threshold must be provided by subtypes.
 */
public abstract class OfAKindStrategy implements ScoringStrategy {

    private final int threshold;

    public OfAKindStrategy(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public int getScore(Roll roll) {
        var pairs = roll.getPairs();
        return pairs.stream()
            .filter(p -> p.frequency() >= threshold)
            .limit(threshold)
            .mapToInt(Pair::value)
            .sum() * threshold;
    }

}
