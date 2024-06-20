package org.codingdojo.yatzy1.scoring.strategies.impl;

import org.codingdojo.yatzy1.scoring.dice.Roll;
import org.codingdojo.yatzy1.scoring.strategies.ScoringStrategy;

/**
 * This {@link ScoringStrategy} scores the sum two pairs of dice with the same number,
 * regardless of their frequencies.
 * Examples:
 * - {1,1,2,2,2} -> 6
 * - {1,1,2,3,3} -> 8
 *
 * @see <a href="https://sammancoaching.org/kata_descriptions/yatzy.html">Two pairs Kata Rules</a>
 */
public class TwoPairStrategy implements ScoringStrategy {

    @Override
    public int getScore(Roll roll) {
        var pairs = roll.getPairs();
        if (pairs.size() < 2) {
            return 0;
        }
        return pairs.stream()
            .mapToInt(pair -> pair.value() * 2)
            .sum();
    }

}
