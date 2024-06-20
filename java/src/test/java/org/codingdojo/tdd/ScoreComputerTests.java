package org.codingdojo.tdd;

import org.codingdojo.dataset.RollDataset;
import org.codingdojo.yatzy1.scoring.ScoreComputer;
import org.codingdojo.yatzy1.scoring.strategies.CategoryName;
import org.codingdojo.yatzy1.scoring.strategies.factories.StrategyFactory;
import org.codingdojo.yatzy1.scoring.strategies.impl.LargeStraightStrategy;
import org.codingdojo.yatzy1.scoring.strategies.impl.YatzyStrategy;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ScoreComputerTests {

    @Mock
    private StrategyFactory categoryFactory;

    @InjectMocks
    private ScoreComputer scoreComputer;

    ///////////////////////////////////////////////////////////
    // TESTS
    ///////////////////////////////////////////////////////////

    @ParameterizedTest
    @EnumSource(
        value = RollDataset.class,
        names = {"LARGE_STRAIGHT", "LARGE_STRAIGHT_SHUFFLED"},
        mode = EnumSource.Mode.EXCLUDE)
    void getScore_whenLargeStraightCategoryAndRollIsAnythingElse_shouldReturnZero(RollDataset data) {
        // Given
        var categoryName = CategoryName.LARGE_STRAIGHT;
        // When
        when(categoryFactory.of(Mockito.any(CategoryName.class)))
            .thenReturn(new LargeStraightStrategy());
        int score = scoreComputer.getScore(data.getRoll(), categoryName);
        // Then
        assertEquals(0, score);
    }

    @ParameterizedTest
    @EnumSource(value = RollDataset.class, names = {"LARGE_STRAIGHT", "LARGE_STRAIGHT_SHUFFLED"})
    void getScore_whenLargeStraightCategoryAndRollIsLargeStraight_shouldReturn20(RollDataset data) {
        // Given
        var categoryName = CategoryName.LARGE_STRAIGHT;
        var roll = data.getRoll();
        // When
        when(categoryFactory.of(Mockito.any(CategoryName.class)))
            .thenReturn(new LargeStraightStrategy());
        int score = scoreComputer.getScore(roll, categoryName);
        // Then
        assertEquals(20, score);
    }

    @ParameterizedTest
    @EnumSource(value = RollDataset.class, names = {"YATZY_1", "YATZY_2", "YATZY_4", "YATZY_6"})
    void getScore_whenYatzyCategoryAndRollIsYatzyRoll_shouldReturn50(RollDataset data) {
        // Given
        var categoryName = CategoryName.YATZY;
        var roll = data.getRoll();
        // When
        when(categoryFactory.of(Mockito.any(CategoryName.class)))
            .thenReturn(new YatzyStrategy());
        int score = scoreComputer.getScore(roll, categoryName);
        // Then
        assertEquals(50, score);
    }

}
