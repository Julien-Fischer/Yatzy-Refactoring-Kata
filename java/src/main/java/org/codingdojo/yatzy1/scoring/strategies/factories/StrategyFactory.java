package org.codingdojo.yatzy1.scoring.strategies.factories;

import org.codingdojo.yatzy1.scoring.strategies.CategoryName;
import org.codingdojo.yatzy1.scoring.strategies.ScoringStrategy;

/**
 * A factory class for vending {@link ScoringStrategy} objects.
 *
 * @see CategoryName
 * @see ScoringStrategy
 */
public interface StrategyFactory {

    /**
     * Creates the strategy that best matches the specified {@link CategoryName}.
     *
     * @param name  the name of the desired category
     * @return an instance of the category identified by the specified name
     * @throws IllegalArgumentException if {@code null} is given as input
     */
    ScoringStrategy of (CategoryName name) throws IllegalArgumentException;

}
