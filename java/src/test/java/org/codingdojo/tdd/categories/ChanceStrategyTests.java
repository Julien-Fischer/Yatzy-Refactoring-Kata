package org.codingdojo.tdd.categories;

import org.codingdojo.dataset.RollDataset;
import org.codingdojo.yatzy1.scoring.dice.Roll;
import org.codingdojo.yatzy1.scoring.strategies.ScoringStrategy;
import org.codingdojo.yatzy1.scoring.strategies.impl.ChanceStrategy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ChanceStrategyTests {

    private final ScoringStrategy strategy = new ChanceStrategy();

    ///////////////////////////////////////////////////////////
    // DATASOURCE
    ///////////////////////////////////////////////////////////

    private static Stream<Arguments> rollSumDatasource() {
        return Stream.of(
            arguments( 5, RollDataset.YATZY_1.getRoll()),
            arguments(20, RollDataset.YATZY_4.getRoll()),
            arguments(15, RollDataset.SMALL_STRAIGHT.getRoll()),
            arguments(20, RollDataset.LARGE_STRAIGHT.getRoll()),
            arguments(16, RollDataset.PAIR_3_3.getRoll())
        );
    }

    ///////////////////////////////////////////////////////////
    // UNIT TESTS
    ///////////////////////////////////////////////////////////

    @ParameterizedTest
    @MethodSource("rollSumDatasource")
    void sum_shouldReturnTheSumOfTheDiceInThisRoll(int expected, Roll roll) {
        // When
        int sum = strategy.getSum(roll);
        // Then
        assertEquals(expected, sum);
    }

}
