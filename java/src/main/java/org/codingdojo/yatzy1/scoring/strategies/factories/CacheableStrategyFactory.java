package org.codingdojo.yatzy1.scoring.strategies.factories;

import org.codingdojo.yatzy1.scoring.strategies.CategoryName;
import org.codingdojo.yatzy1.scoring.strategies.ScoringStrategy;
import org.codingdojo.yatzy1.scoring.strategies.impl.*;
import org.codingdojo.yatzy1.scoring.strategies.impl.numbers.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * A {@link StrategyFactory} that caches {@link ScoringStrategy} instances
 * to reuse them over and over during the lifetime of the application.
 */
public class CacheableStrategyFactory implements StrategyFactory {

    private static CacheableStrategyFactory instance;
    private final Map<CategoryName, ScoringStrategy> cache = new HashMap<>();

    public static CacheableStrategyFactory getInstance() {
        if (instance == null) {
            instance = new CacheableStrategyFactory();
        }
        return instance;
    }

    // Prevent direct instantiation
    private CacheableStrategyFactory() {}

    @Override
    public ScoringStrategy of(CategoryName name) throws NullPointerException {
        Objects.requireNonNull(name, this::getMessage);
        if (!cache.containsKey(name)) {
            cache.put(name, createCategory(name));
        }
        return cache.get(name);
    }

    private String getMessage() {
        return "Category name can not be null.\nSupported values: "
            + Arrays.toString(CategoryName.values());
    }

    private ScoringStrategy createCategory(CategoryName name) {
        return switch (name) {
            case SMALL_STRAIGHT  -> new SmallStraightStrategy();
            case LARGE_STRAIGHT  -> new LargeStraightStrategy();
            case ONES            -> new OnesStrategy();
            case TWOS            -> new TwosStrategy();
            case THREES          -> new ThreesStrategy();
            case FOURS           -> new FoursStrategy();
            case FIVES           -> new FivesStrategy();
            case SIXES           -> new SixesStrategy();
            case CHANCE          -> new ChanceStrategy();
            case PAIR            -> new PairStrategy();
            case THREE_OF_A_KIND -> new ThreeOfAKindStrategy();
            case FOUR_OF_A_KIND  -> new FourOfAKindStrategy();
            case YATZY           -> new YatzyStrategy();
            case TWO_PAIR        -> new TwoPairStrategy();
            case FULL_HOUSE      -> new FullHouseStrategy();
        };
    }

}
