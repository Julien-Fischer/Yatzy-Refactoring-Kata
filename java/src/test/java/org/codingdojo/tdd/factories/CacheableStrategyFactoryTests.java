package org.codingdojo.tdd.factories;

import org.codingdojo.yatzy1.scoring.strategies.CategoryName;
import org.codingdojo.yatzy1.scoring.strategies.factories.CacheableStrategyFactory;
import org.codingdojo.yatzy1.scoring.strategies.impl.*;
import org.codingdojo.yatzy1.scoring.strategies.impl.numbers.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CacheableStrategyFactoryTests {

    private final CacheableStrategyFactory factory = CacheableStrategyFactory.getInstance();

    ///////////////////////////////////////////////////////////
    // DATASET
    ///////////////////////////////////////////////////////////

    static Stream<Arguments> strategyTypesDatasource() {
        var map = new HashMap<CategoryName, Class<?>>();
        map.put(CategoryName.SMALL_STRAIGHT,    SmallStraightStrategy.class);
        map.put(CategoryName.LARGE_STRAIGHT,    LargeStraightStrategy.class);
        map.put(CategoryName.ONES,              OnesStrategy.class);
        map.put(CategoryName.TWOS,              TwosStrategy.class);
        map.put(CategoryName.THREES,            ThreesStrategy.class);
        map.put(CategoryName.FOURS,             FoursStrategy.class);
        map.put(CategoryName.FIVES,             FivesStrategy.class);
        map.put(CategoryName.SIXES,             SixesStrategy.class);
        map.put(CategoryName.CHANCE,            ChanceStrategy.class);
        map.put(CategoryName.PAIR,              PairStrategy.class);
        map.put(CategoryName.THREE_OF_A_KIND,   ThreeOfAKindStrategy.class);
        map.put(CategoryName.FOUR_OF_A_KIND,    FourOfAKindStrategy.class);
        map.put(CategoryName.YATZY,             YatzyStrategy.class);
        return map.entrySet().stream()
            .map(entry -> Arguments.of(entry.getValue(), entry.getKey()));
    }

    ///////////////////////////////////////////////////////////
    // TESTS
    ///////////////////////////////////////////////////////////

    @Test
    void getInstance_whenCalledMultipleTimes_shouldAlwaysReturnTheSameInstance() {
        // Given
        var first = CacheableStrategyFactory.getInstance();
        // When
        var second = CacheableStrategyFactory.getInstance();
        // Then
        assertSame(first, second);
    }

    @Test
    void of_whenNullParameter_shouldThrowException() {
        assertThrows(NullPointerException.class, () -> factory.of(null));
    }

    @ParameterizedTest
    @EnumSource(CategoryName.class)
    void of_shouldReturnTheCategoryIdentifiedByItsName(CategoryName categoryName) {
        // Given
        var first = factory.of(categoryName);
        // When
        var second = factory.of(categoryName);
        // Then
        assertSame(first, second);
    }

    @ParameterizedTest
    @MethodSource("strategyTypesDatasource")
    void of_whenCalledMultipleTimes_shouldAlwaysReturnTheSameCategoryInstance(Class<?> expected, CategoryName categoryName) {
        // When
        var actual = factory.of(categoryName);
        // Then
        assertInstanceOf(expected, actual);
    }

}
