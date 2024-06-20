package org.codingdojo.tdd.categories;

import org.codingdojo.dataset.RollDataset;
import org.codingdojo.yatzy1.scoring.strategies.ScoringStrategy;
import org.codingdojo.yatzy1.scoring.strategies.impl.SmallStraightStrategy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmallStraightStrategyTests {

    private final ScoringStrategy strategy = new SmallStraightStrategy();

    @ParameterizedTest
    @EnumSource(value = RollDataset.class, names = {"SMALL_STRAIGHT", "SMALL_STRAIGHT_SHUFFLED"})
    void getScore_whenSmallStraight_shouldReturn15RegardlessOfTheirOrder(RollDataset data) {
        // Given
        var roll = data.getRoll();
        // When
        var actual = strategy.getScore(roll);
        // Then
        assertEquals(15, actual);
    }

    @ParameterizedTest
    @EnumSource(value = RollDataset.class, names = {"SMALL_STRAIGHT", "SMALL_STRAIGHT_SHUFFLED"}, mode = EnumSource.Mode.EXCLUDE)
    void getScore_whenAnythingOtherThanSmallStraight_shouldReturnZero(RollDataset data) {
        // Given
        var roll = data.getRoll();
        // When
        var actual = strategy.getScore(roll);
        // Then
        assertEquals(0, actual);
    }

}
