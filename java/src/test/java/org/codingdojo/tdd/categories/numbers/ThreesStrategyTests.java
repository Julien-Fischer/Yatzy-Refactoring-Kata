package org.codingdojo.tdd.categories.numbers;

import org.codingdojo.dataset.RollDataset;
import org.codingdojo.yatzy1.scoring.dice.Roll;
import org.codingdojo.yatzy1.scoring.strategies.ScoringStrategy;
import org.codingdojo.yatzy1.scoring.strategies.impl.numbers.ThreesStrategy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ThreesStrategyTests {

    private final ScoringStrategy strategy = new ThreesStrategy();

    ///////////////////////////////////////////////////////////
    // DATASETS
    ///////////////////////////////////////////////////////////

    private static Stream<Arguments> scoreSource() {
        return Stream.of(
            arguments(3, RollDataset.SMALL_STRAIGHT.getRoll()),
            arguments(3, RollDataset.SMALL_STRAIGHT_SHUFFLED.getRoll()),
            arguments(3, RollDataset.LARGE_STRAIGHT.getRoll()),
            arguments(3, RollDataset.LARGE_STRAIGHT_SHUFFLED.getRoll()),
            arguments(6, RollDataset.PAIR_3_3.getRoll()),
            arguments(9, RollDataset.PAIR_3_3_3.getRoll()),
            arguments(6, RollDataset.PAIR_2_2_3_3.getRoll()),
            arguments(6, RollDataset.PAIR_3_3_4_4_4.getRoll()),
            arguments(3, RollDataset.PAIR_1_1.getRoll()),
            arguments(3, RollDataset.PAIR_5_5.getRoll())
        );
    }

    ///////////////////////////////////////////////////////////
    // UNIT TESTS
    ///////////////////////////////////////////////////////////

    @ParameterizedTest
    @EnumSource(
        value = RollDataset.class,
        names = {
            "SMALL_STRAIGHT",
            "SMALL_STRAIGHT_SHUFFLED",
            "LARGE_STRAIGHT",
            "LARGE_STRAIGHT_SHUFFLED",
            "PAIR_3_3",
            "PAIR_3_3_3",
            "PAIR_2_2_3_3",
            "PAIR_3_3_4_4_4",
            "PAIR_1_1",
            "PAIR_5_5",
            "PAIR_1_1_1_1"
        },
        mode = EnumSource.Mode.EXCLUDE
    )
    void getScore_whenRollNotContainsThrees_shouldReturnZero(RollDataset data) {
        // Given
        var roll = data.getRoll();
        // When
        var actual = strategy.getScore(roll);
        // Then
        assertEquals(0, actual);
    }

    @ParameterizedTest
    @MethodSource("scoreSource")
    void getScore_whenRollContainsThrees_shouldReturnSumOfMatchingDice(int expected, Roll roll) {
        // When
        var actual = strategy.getScore(roll);
        // Then
        assertEquals(expected, actual);
    }
}
