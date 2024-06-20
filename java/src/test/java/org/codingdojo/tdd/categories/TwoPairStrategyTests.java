package org.codingdojo.tdd.categories;

import org.codingdojo.dataset.RollDataset;
import org.codingdojo.yatzy1.scoring.dice.Roll;
import org.codingdojo.yatzy1.scoring.strategies.ScoringStrategy;
import org.codingdojo.yatzy1.scoring.strategies.impl.TwoPairStrategy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TwoPairStrategyTests {

    private final ScoringStrategy strategy = new TwoPairStrategy();

    ///////////////////////////////////////////////////////////
    // DATASETS
    ///////////////////////////////////////////////////////////

    private static Stream<Arguments> pairScoreSource() {
        return Stream.of(
            arguments(10, RollDataset.PAIR_2_2_3_3.getRoll()),
            arguments(22, RollDataset.PAIR_5_5_5_6_6.getRoll()),
            arguments(10, RollDataset.PAIR_1_1_1_4_4.getRoll()),
            arguments(14, RollDataset.PAIR_3_3_4_4_4.getRoll())
        );
    }

    ///////////////////////////////////////////////////////////
    // UNIT TESTS
    ///////////////////////////////////////////////////////////

    @ParameterizedTest
    @EnumSource(
        value = RollDataset.class,
        names = {"PAIR_2_2_3_3", "PAIR_5_5_5_6_6", "PAIR_1_1_1_4_4", "PAIR_3_3_4_4_4"},
        mode = EnumSource.Mode.EXCLUDE
    )
    void getScore_whenLessThanTwoPairsInTheRoll_shouldReturnZero(RollDataset data) {
        // Given
        var roll = data.getRoll();
        // When
        var actual = strategy.getScore(roll);
        // Then
        assertEquals(0, actual);
    }

    @ParameterizedTest
    @MethodSource("pairScoreSource")
    void getScore_whenTwoPairsFoundInTheRoll_shouldReturnTheSumOfThePairs(int expected, Roll roll) {
        // When
        var actual = strategy.getScore(roll);
        // Then
        assertEquals(expected, actual);
    }
}
