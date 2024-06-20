package org.codingdojo.tdd.categories.numbers;

import org.codingdojo.dataset.RollDataset;
import org.codingdojo.yatzy1.scoring.dice.Roll;
import org.codingdojo.yatzy1.scoring.strategies.ScoringStrategy;
import org.codingdojo.yatzy1.scoring.strategies.impl.numbers.FoursStrategy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class FoursStrategyTests {

    private final ScoringStrategy strategy = new FoursStrategy();

    ///////////////////////////////////////////////////////////
    // DATASETS
    ///////////////////////////////////////////////////////////

    private static Stream<Arguments> scoreSource() {
        return Stream.of(
            arguments(20, RollDataset.YATZY_4.getRoll()),
            arguments( 4, RollDataset.SMALL_STRAIGHT.getRoll()),
            arguments( 4, RollDataset.SMALL_STRAIGHT_SHUFFLED.getRoll()),
            arguments( 4, RollDataset.LARGE_STRAIGHT.getRoll()),
            arguments( 4, RollDataset.LARGE_STRAIGHT_SHUFFLED.getRoll()),
            arguments(16, RollDataset.PAIR_4_4_4_4.getRoll()),
            arguments(12, RollDataset.PAIR_3_3_4_4_4.getRoll()),
            arguments( 4, RollDataset.PAIR_3_3_3.getRoll()),
            arguments( 4, RollDataset.PAIR_3_3.getRoll()),
            arguments( 8, RollDataset.PAIR_1_1_1_4_4.getRoll()),
            arguments( 4, RollDataset.PAIR_1_1.getRoll()),
            arguments( 4, RollDataset.PAIR_5_5.getRoll())
        );
    }

    ///////////////////////////////////////////////////////////
    // UNIT TESTS
    ///////////////////////////////////////////////////////////

    @ParameterizedTest
    @EnumSource(
        value = RollDataset.class,
        names = {
            "YATZY_4",
            "SMALL_STRAIGHT",
            "SMALL_STRAIGHT_SHUFFLED",
            "LARGE_STRAIGHT",
            "LARGE_STRAIGHT_SHUFFLED",
            "PAIR_4_4_4_4",
            "PAIR_3_3_4_4_4",
            "PAIR_3_3_3",
            "PAIR_3_3",
            "PAIR_1_1_1_4_4",
            "PAIR_1_1",
            "PAIR_5_5"
        },
        mode = EnumSource.Mode.EXCLUDE
    )
    void getScore_whenRollNotContainsFours_shouldReturnZero(RollDataset data) {
        // Given
        var roll = data.getRoll();
        // When
        var actual = strategy.getScore(roll);
        // Then
        assertEquals(0, actual);
    }

    @ParameterizedTest
    @MethodSource("scoreSource")
    void getScore_whenRollContainsFours_shouldReturnSumOfMatchingDice(int expected, Roll roll) {
        // When
        var actual = strategy.getScore(roll);
        // Then
        assertEquals(expected, actual);
    }
}
