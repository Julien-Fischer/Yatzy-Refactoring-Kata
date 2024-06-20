package org.codingdojo.yatzy1.scoring.dice;

import java.util.*;
import java.util.stream.Collectors;
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
    private List<Integer> sortedList;

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

    @Override
    public boolean isSequential() {
        var sorted = getSortedList();
        for (var i = sorted.size() - 2; i >= 0; i--) {
            if (sorted.get(i) != sorted.get(i + 1) + 1) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int getLowestDie() {
        return getSortedList().get(dices.length - 1);
    }

    @Override
    public Deque<Pair> getPairs() {
        Map<Integer, Integer> counts = new TreeMap<>(Comparator.reverseOrder());
        getSortedList().forEach(die -> counts.merge(die, 1, Integer::sum));
        return counts.entrySet().stream()
            .filter(e -> e.getValue() > 1)
            .map(entry -> new Pair(entry.getKey(), entry.getValue()))
            .collect(Collectors.toCollection(LinkedList::new));
    }

    private List<Integer> getSortedList() {
        if (sortedList == null) {
            sortedList = createSortedList();
        }
        return sortedList;
    }

    private List<Integer> createSortedList() {
        return Arrays.stream(dices)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .toList();
    }

    @Override
    public String toString() {
        return "ImmutableRoll{" + Arrays.toString(dices) + '}';
    }
}
