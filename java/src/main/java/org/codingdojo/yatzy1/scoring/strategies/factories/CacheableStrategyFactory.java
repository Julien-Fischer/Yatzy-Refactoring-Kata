package org.codingdojo.yatzy1.scoring.strategies.factories;

import org.codingdojo.yatzy1.scoring.strategies.CategoryName;
import org.codingdojo.yatzy1.scoring.strategies.ScoringStrategy;

/**
 * A {@link StrategyFactory} that caches {@link ScoringStrategy} instances
 * to reuse them over and over during the lifetime of the application.
 */
public class CacheableStrategyFactory implements StrategyFactory {


    public static CacheableStrategyFactory getInstance() {
        // TODO: impl
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public ScoringStrategy of(CategoryName name) throws IllegalArgumentException {
        // TODO: impl
        throw new UnsupportedOperationException("Not implemented yet");
    }

}
