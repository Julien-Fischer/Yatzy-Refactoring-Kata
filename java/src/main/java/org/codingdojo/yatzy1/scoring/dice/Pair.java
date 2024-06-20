package org.codingdojo.yatzy1.scoring.dice;

/**
 * In the context of this version of Yatzy, a Pair is defined as the presence
 * of two or more matching dice in a {@link Roll}.
 * Examples or a pair:
 * - {3, 3}
 * - {3, 3, 3}
 * - {3, 3, 3, 3}
 * - etc...
 *
 * Pairs are {@link Comparable} with each other, based on their value only, and
 * regardless of their frequency in the roll.
 */
public record Pair(int value, int frequency) implements Comparable<Pair> {

    public int getSum() {
        return value * frequency;
    }

    @Override
    public int compareTo(Pair other) {
        return Integer.compare(value, other.value());
    }

}
