package org.codingdojo.yatzy1.scoring;

import org.codingdojo.yatzy1.scoring.dice.Roll;
import org.codingdojo.yatzy1.scoring.strategies.CategoryName;
import org.codingdojo.yatzy1.scoring.strategies.factories.StrategyFactory;

/**
 * A class responsible for calculating the score of a {@link Roll} for
 * a given category
 *
 * @see Roll
 * @see CategoryName
 * @see StrategyFactory
 */
public class ScoreComputer {

    private final StrategyFactory strategyFactory;

    public ScoreComputer(StrategyFactory factory) {
        this.strategyFactory = factory;
    }

    /**
     * Returns the score of a given {@link Roll}, given a specified
     * {@link CategoryName}.
     *
     * @param roll  the roll to score for the specified category name
     * @param categoryName  the name of the category name to score the
     *                      roll for
     * @return the number of points this roll scored for this category,
     * or zero if it does not match its requirements
     */
    public int getScore(Roll roll, CategoryName categoryName) {
        return strategyFactory.of(categoryName).getScore(roll);
    }

}
