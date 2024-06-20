package org.codingdojo.yatzy1.scoring.dice;

import java.util.stream.IntStream;

/**
 * An immutable {@link Roll} represents the result of a die throw at a specific
 * point of the game; hence it must be immutable by definition.
 * Mutable rolls can be implemented by implementing the {@link Roll} interface
 * when states and rerolls should be managed within an object. However, the
 * immutable version is preferred for communication between objects to ensure
 * data safety and consistency across multiple layers of processing.
 */
public class ImmutableRoll implements Roll {

    private final int[] dices;

    public ImmutableRoll(int die1, int die2, int die3, int die4, int die5) {
        dices = new int[] {die1, die2, die3, die4, die5};
    }

    @Override
    public int getSum() {
        return IntStream.of(dices).sum();
    }

    @Override
    public boolean isDeterministic() {
        return IntStream.of(dices).distinct().count() == 1;
    }
}
