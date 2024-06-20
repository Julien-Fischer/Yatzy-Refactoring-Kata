package org.codingdojo.tdd.categories;

import org.codingdojo.dataset.RollDataset;
import org.codingdojo.yatzy1.scoring.dice.Roll;
import org.codingdojo.yatzy1.scoring.strategies.ScoringStrategy;
import org.codingdojo.yatzy1.scoring.strategies.impl.FourOfAKindStrategy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class FourOfAKindStrategyTests {

    private final ScoringStrategy strategy = new FourOfAKindStrategy();

    ///////////////////////////////////////////////////////////
    // DATASETS
    ///////////////////////////////////////////////////////////

    private static Stream<Arguments> scoreSource() {
        return Stream.of(
            arguments( 4, RollDataset.YATZY_1.getRoll()),
            arguments( 8, RollDataset.YATZY_2.getRoll()),
            arguments(16, RollDataset.YATZY_4.getRoll()),
            arguments(24, RollDataset.YATZY_6.getRoll()),
            arguments(24, RollDataset.PAIR_6_6_6_6.getRoll()),
            arguments( 4, RollDataset.PAIR_1_1_1_1.getRoll()),
            arguments(16, RollDataset.PAIR_4_4_4_4.getRoll())
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
            "YATZY_2",
            "YATZY_4",
            "YATZY_6",
            "PAIR_6_6_6_6",
            "PAIR_1_1_1_1",
            "PAIR_4_4_4_4"
        },
        mode = EnumSource.Mode.EXCLUDE
    )
    void getScore_whenLessThanFourOfAKind_shouldReturnZero(RollDataset data) {
        // Given
        var roll = data.getRoll();
        // When
        var actual = strategy.getScore(roll);
        // Then
        assertEquals(0, actual);
    }

    @ParameterizedTest
    @MethodSource("scoreSource")
    void getScore_whenAtLeastFourOffAKind_shouldReturnSumOfMatchingDice(int expected, Roll roll) {
        // When
        var actual = strategy.getScore(roll);
        // Then
        assertEquals(expected, actual);
    }
}
