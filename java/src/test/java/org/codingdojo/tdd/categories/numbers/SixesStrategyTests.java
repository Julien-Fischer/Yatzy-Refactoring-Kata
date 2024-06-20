package org.codingdojo.tdd.categories.numbers;

import org.codingdojo.dataset.RollDataset;
import org.codingdojo.yatzy1.scoring.dice.Roll;
import org.codingdojo.yatzy1.scoring.strategies.ScoringStrategy;
import org.codingdojo.yatzy1.scoring.strategies.impl.numbers.SixesStrategy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SixesStrategyTests {

    private final ScoringStrategy strategy = new SixesStrategy();

    ///////////////////////////////////////////////////////////
    // DATASETS
    ///////////////////////////////////////////////////////////

    private static Stream<Arguments> scoreSource() {
        return Stream.of(
            arguments(30, RollDataset.YATZY_6.getRoll()),
            arguments( 6, RollDataset.LARGE_STRAIGHT.getRoll()),
            arguments( 6, RollDataset.LARGE_STRAIGHT_SHUFFLED.getRoll()),
            arguments(24, RollDataset.PAIR_6_6_6_6.getRoll()),
            arguments(12, RollDataset.PAIR_5_5_5_6_6.getRoll()),
            arguments( 6, RollDataset.PAIR_1_1_1_1.getRoll()),
            arguments( 6, RollDataset.PAIR_2_2_3_3.getRoll()),
            arguments( 6, RollDataset.PAIR_4_4_4_4.getRoll())
        );
    }

    ///////////////////////////////////////////////////////////
    // UNIT TESTS
    ///////////////////////////////////////////////////////////

    @ParameterizedTest
    @EnumSource(
        value = RollDataset.class,
        names = {
            "YATZY_6",
            "LARGE_STRAIGHT",
            "LARGE_STRAIGHT_SHUFFLED",
            "PAIR_6_6_6_6",
            "PAIR_5_5_5_6_6",
            "PAIR_1_1_1_1",
            "PAIR_2_2_3_3",
            "PAIR_4_4_4_4"
        },
        mode = EnumSource.Mode.EXCLUDE
    )
    void getScore_whenRollNotContainsSixes_shouldReturnZero(RollDataset data) {
        // Given
        var roll = data.getRoll();
        // When
        var actual = strategy.getScore(roll);
        // Then
        assertEquals(0, actual);
    }

    @ParameterizedTest
    @MethodSource("scoreSource")
    void getScore_whenRollContainsSixes_shouldReturnSumOfMatchingDice(int expected, Roll roll) {
        // When
        var actual = strategy.getScore(roll);
        // Then
        assertEquals(expected, actual);
    }
}
