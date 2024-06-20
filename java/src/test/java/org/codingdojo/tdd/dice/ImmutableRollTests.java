package org.codingdojo.tdd.dice;

import org.codingdojo.dataset.RollDataset;
import org.codingdojo.yatzy1.scoring.dice.Roll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ImmutableRollTests {

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

    private static Stream<Arguments> rollLowestDieDatasource() {
        return Stream.of(
            arguments(1, RollDataset.YATZY_1.getRoll()),
            arguments(4, RollDataset.YATZY_4.getRoll()),
            arguments(1, RollDataset.SMALL_STRAIGHT.getRoll()),
            arguments(2, RollDataset.LARGE_STRAIGHT.getRoll()),
            arguments(1, RollDataset.PAIR_3_3.getRoll()),
            arguments(4, RollDataset.PAIR_6_6_6_6.getRoll())
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

    @ParameterizedTest
    @EnumSource(value = RollDataset.class, names = {"YATZY_1", "YATZY_2", "YATZY_4"})
    void isDeterministic_whenAllDiceHaveTheSameValue_shouldReturnTrue(RollDataset data) {
        // Given
        var roll = data.getRoll();
        // When + Then
        assertTrue(roll.isDeterministic());
    }

    @ParameterizedTest
    @EnumSource(
        value = RollDataset.class,
        names = {"YATZY_1", "YATZY_2", "YATZY_4", "YATZY_6"},
        mode = EnumSource.Mode.EXCLUDE
    )
    void isDeterministic_whenSomeDiceHaveDifferentValues_shouldReturnFalse(RollDataset data) {
        // Given
        var roll = data.getRoll();
        // When + Then
        assertFalse(roll.isDeterministic());
    }

    @ParameterizedTest
    @EnumSource(value = RollDataset.class, names = {"SMALL_STRAIGHT", "LARGE_STRAIGHT"})
    void isSequential_whenSequential_shouldReturnTrue(RollDataset data) {
        // Given
        var roll = data.getRoll();
        // When + Then
        assertTrue(roll.isSequential());
    }

    @ParameterizedTest
    @EnumSource(
        value = RollDataset.class,
        names = {"SMALL_STRAIGHT", "LARGE_STRAIGHT", "SMALL_STRAIGHT_SHUFFLED", "LARGE_STRAIGHT_SHUFFLED"},
        mode = EnumSource.Mode.EXCLUDE
    )
    void isSequential_whenNotSequential_shouldReturnFalse(RollDataset data) {
        // Given
        var roll = data.getRoll();
        // When + Then
        assertFalse(roll.isSequential());
    }

    @ParameterizedTest
    @MethodSource("rollLowestDieDatasource")
    void getLowestDie_shouldReturnLowestDie(int expected, Roll roll) {
        // When
        var actual = roll.getLowestDie();
        // Then
        assertEquals(expected, actual);
    }

}
