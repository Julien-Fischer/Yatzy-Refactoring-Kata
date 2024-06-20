package org.codingdojo.tdd.categories.numbers;

import org.codingdojo.dataset.RollDataset;
import org.codingdojo.yatzy1.scoring.dice.Roll;
import org.codingdojo.yatzy1.scoring.strategies.ScoringStrategy;
import org.codingdojo.yatzy1.scoring.strategies.impl.numbers.TwosStrategy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TwosStrategyTests {

    private final ScoringStrategy strategy = new TwosStrategy();

    ///////////////////////////////////////////////////////////
    // DATASETS
    ///////////////////////////////////////////////////////////

    private static Stream<Arguments> scoreSource() {
        return Stream.of(
            arguments(10, RollDataset.YATZY_2.getRoll()),
            arguments(2, RollDataset.SMALL_STRAIGHT.getRoll()),
            arguments(2, RollDataset.SMALL_STRAIGHT_SHUFFLED.getRoll()),
            arguments(2, RollDataset.LARGE_STRAIGHT.getRoll()),
            arguments(2, RollDataset.LARGE_STRAIGHT_SHUFFLED.getRoll()),
            arguments(4, RollDataset.PAIR_2_2_3_3.getRoll())
        );
    }

    ///////////////////////////////////////////////////////////
    // UNIT TESTS
    ///////////////////////////////////////////////////////////

    @ParameterizedTest
    @EnumSource(
        value = RollDataset.class,
        names = {
            "YATZY_2",
            "SMALL_STRAIGHT",
            "SMALL_STRAIGHT_SHUFFLED",
            "LARGE_STRAIGHT",
            "LARGE_STRAIGHT_SHUFFLED",
            "PAIR_2_2_3_3"
        },
        mode = EnumSource.Mode.EXCLUDE
    )
    void getScore_whenRollNotContainsTwos_shouldReturnZero(RollDataset data) {
        // Given
        var roll = data.getRoll();
        // When
        var actual = strategy.getScore(roll);
        // Then
        assertEquals(0, actual);
    }

    @ParameterizedTest
    @MethodSource("scoreSource")
    void getScore_whenRollContainsTwos_shouldReturnSumOfMatchingDice(int expected, Roll roll) {
        // When
        var actual = strategy.getScore(roll);
        // Then
        assertEquals(expected, actual);
    }
}
