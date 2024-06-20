package org.codingdojo.yatzy1.scoring.strategies.impl;

import org.codingdojo.yatzy1.scoring.dice.Roll;
import org.codingdojo.yatzy1.scoring.strategies.ScoringStrategy;

/**
 * This {@link ScoringStrategy} scores the sum of the two highest matching dice,
 * regardless of their frequencies.
 * Examples:
 * - {3,3,2,4,1} -> 6
 * - {3,3,3,4,1} -> 6
 * - {3,3,3,3,1} -> 6
 *
 * @see <a href="https://sammancoaching.org/kata_descriptions/yatzy.html">Chance Kata Rules</a>
 */
public class PairStrategy implements ScoringStrategy {

    @Override
    public int getScore(Roll roll) {
        var optionalPair = roll.getHighestPair();
        return optionalPair.map(pair -> pair.value() * 2).orElse(0);
    }

}
