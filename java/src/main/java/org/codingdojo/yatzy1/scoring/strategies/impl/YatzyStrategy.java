package org.codingdojo.yatzy1.scoring.strategies.impl;

import org.codingdojo.yatzy1.scoring.dice.Roll;
import org.codingdojo.yatzy1.scoring.strategies.ScoringStrategy;

/**
 * This {@link ScoringStrategy} scores 50 points if all the dice in a
 * {@link Roll} have the same number; zero otherwise.
 *
 * @see <a href="https://sammancoaching.org/kata_descriptions/yatzy.html">Yatzy Kata Rules</a>
 */
public class YatzyStrategy implements ScoringStrategy {

    @Override
    public int getScore(Roll roll) {
        return roll.isDeterministic() ? 50 : 0;
    }

}
