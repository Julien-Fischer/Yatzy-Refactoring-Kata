package org.codingdojo.tdd.dice;

import org.codingdojo.yatzy1.scoring.dice.ImmutableRoll;
import org.codingdojo.yatzy1.scoring.dice.Roll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ImmutableRollTests {

    ///////////////////////////////////////////////////////////
    // DATASET
    ///////////////////////////////////////////////////////////

    enum RollDataset {
        YATZY_1             (new ImmutableRoll(1, 1, 1, 1, 1)),
        YATZY_4             (new ImmutableRoll(4, 4, 4, 4, 4)),
        SMALL_STRAIGHT      (new ImmutableRoll(1, 2, 3, 4, 5)),
        LARGE_STRAIGHT      (new ImmutableRoll(2, 3, 4, 5, 6));

        private final Roll roll;

        RollDataset(Roll roll) {
            this.roll = roll;
        }

        public Roll getRoll() {
            return roll;
        }
    }

    private static Stream<Arguments> rollSumDatasource() {
        return Stream.of(
            arguments( 5, RollDataset.YATZY_1.getRoll()),
            arguments(20, RollDataset.YATZY_4.getRoll()),
            arguments(15, RollDataset.SMALL_STRAIGHT.getRoll()),
            arguments(20, RollDataset.LARGE_STRAIGHT.getRoll())
        );
    }

    ///////////////////////////////////////////////////////////
    // UNIT TESTS
    ///////////////////////////////////////////////////////////

    @ParameterizedTest
    @MethodSource("rollSumDatasource")
    void sum_shouldReturnTheSumOfTheDiceInThisRoll(int expected, Roll roll) {
        // When
        int sum = roll.getSum();
        // Then
        assertEquals(expected, sum);
    }

}
