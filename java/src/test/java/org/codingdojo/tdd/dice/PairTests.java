package org.codingdojo.tdd.dice;

import org.codingdojo.yatzy1.scoring.dice.Pair;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class PairTests {

    ///////////////////////////////////////////////////////////
    // DATASETS
    ///////////////////////////////////////////////////////////

    enum PairDataset {
        PAIR_1 (new Pair(1, 3)),
        PAIR_2 (new Pair(2, 2)),
        PAIR_3 (new Pair(3, 5)),
        PAIR_4 (new Pair(4, 4)),
        PAIR_5 (new Pair(5, 3)),
        PAIR_6 (new Pair(6, 2));

        private final Pair pair;

        PairDataset(Pair pair) {
            this.pair = pair;
        }

        public Pair getPair() {
            return pair;
        }
    }

    private static Stream<Arguments> pairComparisonSource() {
        return Stream.of(
            arguments( 0, PairDataset.PAIR_1, PairDataset.PAIR_1),
            arguments( 1, PairDataset.PAIR_3, PairDataset.PAIR_2),
            arguments(-1, PairDataset.PAIR_2, PairDataset.PAIR_3),
            arguments( 1, PairDataset.PAIR_4, PairDataset.PAIR_3),
            arguments(-1, PairDataset.PAIR_3, PairDataset.PAIR_4),
            arguments(-1, PairDataset.PAIR_5, PairDataset.PAIR_6)
        );
    }

    ///////////////////////////////////////////////////////////
    // UNIT TESTS
    ///////////////////////////////////////////////////////////

    @ParameterizedTest
    @EnumSource(value = PairDataset.class)
    void getSum_shouldReturnValueTimesFrequency(PairDataset data) {
        // Given
        var pair = data.getPair();
        // When + Then
        assertEquals(pair.value() * pair.frequency(), pair.getSum());
    }

    @ParameterizedTest
    @MethodSource("pairComparisonSource")
    void getSum_shouldReturnValueTimesFrequency(int expected, PairDataset a, PairDataset b) {
        // Given
        var pairA = a.getPair();
        var pairB = b.getPair();
        // When + Then
        assertEquals(expected, pairA.compareTo(pairB));
    }

}
