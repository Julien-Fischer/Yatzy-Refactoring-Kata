package org.codingdojo.tdd.categories;

import org.codingdojo.dataset.RollDataset;
import org.codingdojo.yatzy1.scoring.dice.Roll;
import org.codingdojo.yatzy1.scoring.strategies.ScoringStrategy;
import org.codingdojo.yatzy1.scoring.strategies.impl.FullHouseStrategy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class FullHouseStrategyTests {

    private final ScoringStrategy strategy = new FullHouseStrategy();

    ///////////////////////////////////////////////////////////
    // DATASETS
    ///////////////////////////////////////////////////////////

    private static Stream<Arguments> scoreSource() {
        return Stream.of(
            arguments(27, RollDataset.PAIR_5_5_5_6_6.getRoll()),
            arguments(11, RollDataset.PAIR_1_1_1_4_4.getRoll()),
            arguments(18, RollDataset.PAIR_3_3_4_4_4.getRoll())
        );
    }

    ///////////////////////////////////////////////////////////
    // UNIT TESTS
    ///////////////////////////////////////////////////////////

    @ParameterizedTest
    @EnumSource(
        value = RollDataset.class,
        names = {"PAIR_5_5_5_6_6", "PAIR_1_1_1_4_4", "PAIR_3_3_4_4_4"},
        mode = EnumSource.Mode.EXCLUDE
    )
    void getScore_whenNotFullHouse_shouldReturnZero(RollDataset data) {
        // Given
        var roll = data.getRoll();
        // When
        var actual = strategy.getScore(roll);
        // Then
        assertEquals(0, actual);
    }

    @ParameterizedTest
    @MethodSource("scoreSource")
    void getScore_whenFullHouse_shouldReturnSumOfDice(int expected, Roll roll) {
        // When
        var actual = strategy.getScore(roll);
        // Then
        assertEquals(expected, actual);
    }

}
