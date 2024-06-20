package org.codingdojo.yatzy1.scoring.strategies.impl;

import org.codingdojo.yatzy1.scoring.dice.Roll;
import org.codingdojo.yatzy1.scoring.strategies.ScoringStrategy;

/**
 * This {@link ScoringStrategy} scores the sum of all the dice if the dice are
 * two of a kind and three of a kind.
 * Examples:
 * - 1,1,2,2,2 -> 8
 * - 2,2,3,3,4 -> 0
 *
 * @see <a href="https://sammancoaching.org/kata_descriptions/yatzy.html">Full House Kata Rules</a>
 */
public class FullHouseStrategy implements ScoringStrategy {

    @Override
    public int getScore(Roll roll) {
        var pairs = roll.getPairs();
        if (pairs.size() == 2) {
            var highest = pairs.peekFirst();
            var lowest = pairs.peekLast();
            if (highest.frequency() + lowest.frequency() == 5) {
                return roll.getSum();
            }
        }
        return 0;
    }
}
