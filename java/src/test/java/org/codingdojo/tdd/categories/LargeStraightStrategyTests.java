package org.codingdojo.tdd.categories;

import org.codingdojo.dataset.RollDataset;
import org.codingdojo.yatzy1.scoring.strategies.ScoringStrategy;
import org.codingdojo.yatzy1.scoring.strategies.impl.LargeStraightStrategy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LargeStraightStrategyTests {

    private final ScoringStrategy strategy = new LargeStraightStrategy();

    @ParameterizedTest
    @EnumSource(value = RollDataset.class, names = {"LARGE_STRAIGHT", "LARGE_STRAIGHT_SHUFFLED"})
    void getScore_whenLargeStraight_shouldReturn15RegardlessOfTheirOrder(RollDataset data) {
        // Given
        var roll = data.getRoll();
        // When
        var actual = strategy.getScore(roll);
        // Then
        assertEquals(20, actual);
    }

    @ParameterizedTest
    @EnumSource(value = RollDataset.class, names = {"LARGE_STRAIGHT", "LARGE_STRAIGHT_SHUFFLED"}, mode = EnumSource.Mode.EXCLUDE)
    void getScore_whenAnythingOtherThanLargeStraight_shouldReturnZero(RollDataset data) {
        // Given
        var roll = data.getRoll();
        // When
        var actual = strategy.getScore(roll);
        // Then
        assertEquals(0, actual);
    }

}
