package org.codingdojo.tdd.categories;

import org.codingdojo.dataset.RollDataset;
import org.codingdojo.yatzy1.scoring.strategies.ScoringStrategy;
import org.codingdojo.yatzy1.scoring.strategies.impl.YatzyStrategy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyStrategyTests {

    private final ScoringStrategy strategy = new YatzyStrategy();

    @ParameterizedTest
    @EnumSource(value = RollDataset.class, names = {"YATZY_1", "YATZY_2", "YATZY_4", "YATZY_6"})
    void getScore_whenAllDiceHaveTheSameValue_shouldReturn50(RollDataset data) {
        // Given
        var roll = data.getRoll();
        // When + Then
        assertEquals(50, strategy.getScore(roll));
    }

    @ParameterizedTest
    @EnumSource(value = RollDataset.class, names = {"YATZY_1", "YATZY_2", "YATZY_4", "YATZY_6"}, mode = EnumSource.Mode.EXCLUDE)
    void getScore_whenSomeDiceHaveDifferentValues_shouldReturnZero(RollDataset data) {
        // Given
        var roll = data.getRoll();
        // When + Then
        assertEquals(0, strategy.getScore(roll));
    }

}
