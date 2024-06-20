package org.codingdojo.tdd.categories;

import org.codingdojo.dataset.RollDataset;
import org.codingdojo.yatzy1.scoring.dice.Roll;
import org.codingdojo.yatzy1.scoring.strategies.ScoringStrategy;
import org.codingdojo.yatzy1.scoring.strategies.impl.OnesStrategy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class OnesStrategyTests {

    private final ScoringStrategy strategy = new OnesStrategy();

    ///////////////////////////////////////////////////////////
    // DATASETS
    ///////////////////////////////////////////////////////////

    private static Stream<Arguments> scoreSource() {
        return Stream.of(
            arguments(5, RollDataset.YATZY_1.getRoll()),
            arguments(1, RollDataset.SMALL_STRAIGHT.getRoll()),
            arguments(1, RollDataset.SMALL_STRAIGHT_SHUFFLED.getRoll()),
            arguments(2, RollDataset.PAIR_1_1.getRoll()),
            arguments(1, RollDataset.PAIR_3_3.getRoll()),
            arguments(1, RollDataset.PAIR_5_5.getRoll()),
            arguments(1, RollDataset.PAIR_3_3_3.getRoll()),
            arguments(1, RollDataset.PAIR_6_6_6_6.getRoll()),
            arguments(4, RollDataset.PAIR_1_1_1_1.getRoll()),
            arguments(3, RollDataset.PAIR_1_1_1_4_4.getRoll())
        );
    }

    ///////////////////////////////////////////////////////////
    // UNIT TESTS
    ///////////////////////////////////////////////////////////

    @ParameterizedTest
    @EnumSource(
        value = RollDataset.class,
        names = {
            "YATZY_1",
            "SMALL_STRAIGHT",
            "SMALL_STRAIGHT_SHUFFLED",
            "PAIR_1_1",
            "PAIR_3_3",
            "PAIR_5_5",
            "PAIR_3_3_3",
            "PAIR_6_6_6_6",
            "PAIR_1_1_1_1",
            "PAIR_1_1_1_4_4"
        },
        mode = EnumSource.Mode.EXCLUDE
    )
    void getScore_whenRollNotContainsOnes_shouldReturnZero(RollDataset data) {
        // Given
        var roll = data.getRoll();
        // When
        var actual = strategy.getScore(roll);
        // Then
        assertEquals(0, actual);
    }

    @ParameterizedTest
    @MethodSource("scoreSource")
    void getScore_whenRollContainsOnes_shouldReturnSumOfMatchingDice(int expected, Roll roll) {
        // When
        var actual = strategy.getScore(roll);
        // Then
        assertEquals(expected, actual);
    }
}
