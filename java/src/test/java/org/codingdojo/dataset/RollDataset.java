package org.codingdojo.dataset;

import org.codingdojo.yatzy1.scoring.dice.ImmutableRoll;
import org.codingdojo.yatzy1.scoring.dice.Roll;

public enum RollDataset {
    YATZY_1             (new ImmutableRoll(1, 1, 1, 1, 1)),
    YATZY_2             (new ImmutableRoll(2, 2, 2, 2, 2)),
    YATZY_4             (new ImmutableRoll(4, 4, 4, 4, 4)),
    YATZY_6             (new ImmutableRoll(6, 6, 6, 6, 6)),
    SMALL_STRAIGHT      (new ImmutableRoll(1, 2, 3, 4, 5)),
    LARGE_STRAIGHT      (new ImmutableRoll(2, 3, 4, 5, 6)),
    PAIR_3_3            (new ImmutableRoll(3, 3, 4, 5, 1)),
    PAIR_6_6_6_6        (new ImmutableRoll(6, 6, 6, 6, 4));

    private final Roll roll;

    RollDataset(Roll roll) {
        this.roll = roll;
    }

    public Roll getRoll() {
        return roll;
    }
}
