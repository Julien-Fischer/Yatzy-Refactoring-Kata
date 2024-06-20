package org.codingdojo.integration;

import org.codingdojo.dataset.RollDataset;
import org.codingdojo.yatzy1.scoring.ScoreComputer;
import org.codingdojo.yatzy1.scoring.strategies.CategoryName;
import org.codingdojo.yatzy1.scoring.strategies.factories.CacheableStrategyFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreComputerIT {

    private static ScoreComputer scoreComputer;

    @BeforeAll
    static void beforeAll() {
        scoreComputer = new ScoreComputer(CacheableStrategyFactory.getInstance());
    }

    @ParameterizedTest
    @EnumSource(value = RollDataset.class)
    void getScore_shouldReturnTheSumOfTheDiceInThisRoll(RollDataset data) {
        // Given
        var roll = data.getRoll();
        // When
        int sum = scoreComputer.getScore(roll, CategoryName.CHANCE);
        // Then
        assertEquals(roll.getSum(), sum);
    }

    @ParameterizedTest
    @EnumSource(value = RollDataset.class, names = {"YATZY_1", "YATZY_2", "YATZY_4", "YATZY_6"})
    void getScore_whenAllDiceHaveTheSameValue_shouldReturn50(RollDataset data) {
        // Given
        var roll = data.getRoll();
        // When + Then
        assertEquals(50, scoreComputer.getScore(roll, CategoryName.YATZY));
    }

    @ParameterizedTest
    @EnumSource(
        value = RollDataset.class,
        names = {"YATZY_1", "YATZY_2", "YATZY_4", "YATZY_6"},
        mode = EnumSource.Mode.EXCLUDE)
    void getScore_whenSomeDiceHaveDifferentValues_shouldReturnZero(RollDataset data) {
        // Given
        var roll = data.getRoll();
        // When + Then
        assertEquals(0, scoreComputer.getScore(roll, CategoryName.YATZY));
    }

    @ParameterizedTest
    @EnumSource(value = RollDataset.class, names = {"SMALL_STRAIGHT", "SMALL_STRAIGHT_SHUFFLED"})
    void getScore_whenSmallStraight_shouldReturn15RegardlessOfTheirOrder(RollDataset data) {
        // Given
        var roll = data.getRoll();
        // When
        var actual = scoreComputer.getScore(roll, CategoryName.SMALL_STRAIGHT);
        // Then
        assertEquals(15, actual);
    }

    @ParameterizedTest
    @EnumSource(
        value = RollDataset.class,
        names = {"SMALL_STRAIGHT", "SMALL_STRAIGHT_SHUFFLED"},
        mode = EnumSource.Mode.EXCLUDE
    )
    void getScore_whenAnythingOtherThanSmallStraight_shouldReturnZero(RollDataset data) {
        // Given
        var roll = data.getRoll();
        // When
        var actual = scoreComputer.getScore(roll, CategoryName.SMALL_STRAIGHT);
        // Then
        assertEquals(0, actual);
    }

}
