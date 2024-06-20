package org.codingdojo.yatzy1.scoring.strategies.impl;

import org.codingdojo.yatzy1.scoring.strategies.ScoringStrategy;

/**
 * This {@link ScoringStrategy} scores the sum of four dice that have the
 * same number; zero otherwise.
 * Examples:
 * - {2,2,2,2,5} -> 8
 * - {2,2,2,5,5} -> 0
 * - {2,2,2,2,2} -> 8
 *
 * @see <a href="https://sammancoaching.org/kata_descriptions/yatzy.html">Four of a kind Kata Rules</a>
 */
public class FourOfAKindStrategy extends AbstractOfAKindStrategy {

    public FourOfAKindStrategy() {
        super(4);
    }

}
