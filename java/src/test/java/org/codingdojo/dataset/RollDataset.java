package org.codingdojo.dataset;

import org.codingdojo.yatzy1.scoring.dice.ImmutableRoll;
import org.codingdojo.yatzy1.scoring.dice.Roll;

public enum RollDataset {
    YATZY_1                 (new ImmutableRoll(1, 1, 1, 1, 1)),
    YATZY_2                 (new ImmutableRoll(2, 2, 2, 2, 2)),
    YATZY_4                 (new ImmutableRoll(4, 4, 4, 4, 4)),
    YATZY_6                 (new ImmutableRoll(6, 6, 6, 6, 6)),
    SMALL_STRAIGHT          (new ImmutableRoll(1, 2, 3, 4, 5)),
    LARGE_STRAIGHT          (new ImmutableRoll(2, 3, 4, 5, 6)),
    SMALL_STRAIGHT_SHUFFLED (new ImmutableRoll(2, 3, 1, 5, 4)),
    LARGE_STRAIGHT_SHUFFLED (new ImmutableRoll(3, 2, 5, 6, 4)),
    PAIR_1_1                (new ImmutableRoll(1, 3, 4, 5, 1)),
    PAIR_3_3                (new ImmutableRoll(3, 3, 4, 5, 1)),
    PAIR_5_5                (new ImmutableRoll(5, 3, 4, 5, 1)),
    PAIR_3_3_3              (new ImmutableRoll(3, 3, 4, 3, 1)),
    PAIR_1_1_1_1            (new ImmutableRoll(1, 6, 1, 1, 1)),
    PAIR_4_4_4_4            (new ImmutableRoll(4, 4, 4, 6, 4)),
    PAIR_6_6_6_6            (new ImmutableRoll(1, 6, 6, 6, 6)),
    PAIR_2_2_3_3            (new ImmutableRoll(6, 3, 3, 2, 2)),
    PAIR_5_5_5_6_6          (new ImmutableRoll(6, 5, 5, 6, 5)),
    PAIR_1_1_1_4_4          (new ImmutableRoll(4, 1, 1, 1, 4)),
    PAIR_3_3_4_4_4          (new ImmutableRoll(3, 4, 3, 4, 4));

    private final Roll roll;

    RollDataset(Roll roll) {
        this.roll = roll;
    }

    public Roll getRoll() {
        return roll;
    }
}
