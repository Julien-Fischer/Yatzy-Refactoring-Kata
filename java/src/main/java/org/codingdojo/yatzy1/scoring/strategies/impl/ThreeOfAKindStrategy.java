package org.codingdojo.yatzy1.scoring.strategies.impl;

import org.codingdojo.yatzy1.scoring.strategies.ScoringStrategy;

/**
 * This {@link ScoringStrategy} scores the sum of three dice that have the
 * same number; zero otherwise.
 * Examples:
 * - {3,3,3,4,5} -> 9
 * - {3,3,4,5,6} -> 0
 * - {3,3,3,3,1} -> 9
 *
 * @see <a href="https://sammancoaching.org/kata_descriptions/yatzy.html">Three of a kind Kata Rules</a>
 */
public class ThreeOfAKindStrategy extends OfAKindStrategy {

    public ThreeOfAKindStrategy() {
        super(3);
    }

}
