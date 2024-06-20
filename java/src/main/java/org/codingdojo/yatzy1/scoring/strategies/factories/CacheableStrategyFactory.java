package org.codingdojo.yatzy1.scoring.strategies.factories;

import org.codingdojo.yatzy1.scoring.strategies.CategoryName;
import org.codingdojo.yatzy1.scoring.strategies.ScoringStrategy;

import java.util.Arrays;
import java.util.Objects;

/**
 * A {@link StrategyFactory} that caches {@link ScoringStrategy} instances
 * to reuse them over and over during the lifetime of the application.
 */
public class CacheableStrategyFactory implements StrategyFactory {

    private static CacheableStrategyFactory instance;

    public static CacheableStrategyFactory getInstance() {
        if (instance == null) {
            instance = new CacheableStrategyFactory();
        }
        return instance;
    }

    // Prevent direct instantiation
    private CacheableStrategyFactory() {}

    @Override
    public ScoringStrategy of(CategoryName name) throws IllegalArgumentException {
        Objects.requireNonNull(name, this::getMessage);
        // TODO: impl
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private String getMessage() {
        return "Category name can not be null.\nSupported values: "
            + Arrays.toString(CategoryName.values());
    }

}
