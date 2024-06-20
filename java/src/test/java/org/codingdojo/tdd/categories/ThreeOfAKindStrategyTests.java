package org.codingdojo.tdd.categories;

import org.codingdojo.dataset.RollDataset;
import org.codingdojo.yatzy1.scoring.dice.Roll;
import org.codingdojo.yatzy1.scoring.strategies.ScoringStrategy;
import org.codingdojo.yatzy1.scoring.strategies.impl.ThreeOfAKindStrategy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ThreeOfAKindStrategyTests {

    private final ScoringStrategy strategy = new ThreeOfAKindStrategy();

    ///////////////////////////////////////////////////////////
    // DATASETS
    ///////////////////////////////////////////////////////////

    private static Stream<Arguments> scoreSource() {
        return Stream.of(
            arguments( 3, RollDataset.YATZY_1.getRoll()),
            arguments( 6, RollDataset.YATZY_2.getRoll()),
            arguments(12, RollDataset.YATZY_4.getRoll()),
            arguments(18, RollDataset.YATZY_6.getRoll()),
            arguments(15, RollDataset.PAIR_5_5_5_6_6.getRoll()),
            arguments( 3, RollDataset.PAIR_1_1_1_4_4.getRoll()),
            arguments(12, RollDataset.PAIR_3_3_4_4_4.getRoll()),
            arguments( 9, RollDataset.PAIR_3_3_3.getRoll()),
            arguments(18, RollDataset.PAIR_6_6_6_6.getRoll())
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
            "PAIR_5_5_5_6_6",
            "PAIR_1_1_1_4_4",
            "PAIR_3_3_4_4_4",
            "PAIR_3_3_3",
            "PAIR_6_6_6_6"
        },
        mode = EnumSource.Mode.EXCLUDE
    )
    void getScore_whenLessThanThreeOfAKind_shouldReturnZero(RollDataset data) {
        // Given
        var roll = data.getRoll();
        // When
        var actual = strategy.getScore(roll);
        // Then
        assertEquals(0, actual);
    }

    @ParameterizedTest
    @MethodSource("scoreSource")
    void getScore_whenAtLeastThreeOffAKind_shouldReturnSumOfMatchingDice(int expected, Roll roll) {
        // When
        var actual = strategy.getScore(roll);
        // Then
        assertEquals(expected, actual);
    }
}
