package org.codingdojo.tdd.categories;

import org.codingdojo.dataset.RollDataset;
import org.codingdojo.yatzy1.scoring.dice.Roll;
import org.codingdojo.yatzy1.scoring.strategies.ScoringStrategy;
import org.codingdojo.yatzy1.scoring.strategies.impl.PairStrategy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class PairStrategyTests {

    private final ScoringStrategy strategy = new PairStrategy();

    ///////////////////////////////////////////////////////////
    // DATASETS
    ///////////////////////////////////////////////////////////

    private static Stream<Arguments> pairScoreSource() {
        return Stream.of(
            arguments( 2, RollDataset.PAIR_1_1.getRoll()),
            arguments( 6, RollDataset.PAIR_3_3.getRoll()),
            arguments(10, RollDataset.PAIR_5_5.getRoll()),
            arguments( 6, RollDataset.PAIR_3_3_3.getRoll()),
            arguments(12, RollDataset.PAIR_6_6_6_6.getRoll()),
            arguments( 6, RollDataset.PAIR_2_2_3_3.getRoll()),
            arguments(12, RollDataset.PAIR_5_5_5_6_6.getRoll()),
            arguments( 8, RollDataset.PAIR_1_1_1_4_4.getRoll()),
            arguments( 8, RollDataset.PAIR_3_3_4_4_4.getRoll())
        );
    }

    ///////////////////////////////////////////////////////////
    // UNIT TESTS
    ///////////////////////////////////////////////////////////

    @ParameterizedTest
    @EnumSource(value = RollDataset.class, names = {"SMALL_STRAIGHT", "LARGE_STRAIGHT", "SMALL_STRAIGHT_SHUFFLED", "LARGE_STRAIGHT_SHUFFLED"})
    void getScore_whenNoPairInTheRoll_shouldReturnZero(RollDataset data) {
        // Given
        var roll = data.getRoll();
        // When
        var actual = strategy.getScore(roll);
        // Then
        assertEquals(0, actual);
    }

    @ParameterizedTest
    @MethodSource("pairScoreSource")
    void getScore_whenPairsFoundInTheRoll_shouldReturnTwiceTheDieValue(int expected, Roll roll) {
        // When
        var actual = strategy.getScore(roll);
        // Then
        assertEquals(expected, actual);
    }
}
