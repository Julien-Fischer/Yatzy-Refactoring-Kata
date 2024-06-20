package org.codingdojo.yatzy1.scoring.dice;

import java.util.Deque;
import java.util.Optional;

/**
 * A roll is the result of throwing one or more dice simultaneously.
 * In Yatzy specifically, a roll is defined as a set of five six-faced dice.
 */
public interface Roll {

     /**
      * @return the sum of the dice in this roll.
      */
     int getSum();

     /**
      * A {@link Roll} is deemed deterministic when it has zero variance since all
      * possible values are equal.
      * Examples of deterministic rolls:
      * - {3, 3, 3, 3, 3}
      * - {5, 5, 5, 5, 5}
      *
      * This method does not assume that the roll generator is deterministic;
      * merely that this specific output is.
      *
      * @return true if this roll has only one possible value that occurs
      * with probability 1; false otherwise.
      */
     boolean isDeterministic();

     /**
      * A {@link Roll} is deemed sequential when it contains no duplicates,
      * regardless of the order of the dice.
      *
      * Since Yatzy only uses five six-faced dice, the only possible sequential
      * rolls are:
      * - {1, 2, 3, 4, 5}
      * - {2, 3, 4, 5, 6}
      *
      * @return true if there are no matching dice in this roll.
      */
     boolean isSequential();

     /**
      * @return the die with the lowest value in this {@link Roll}.
      */
     int getLowestDie();

    /**
     * Returns all the pairs in this roll, sorted by descending order.
     * If this roll contains no matching dice, the returned list is empty.
     * In the context of Yatzy, a die roll can contain 0..2 pairs.
     * The concrete choice of data structure and sorting algorithm is left
     * to the implementer.
     *
     * @return a list of {@link Pair}, sorted by descending order
     */
     Deque<Pair> getPairs();

    /**
     * @return the highest pair in this roll if any is found.
     */
     default Optional<Pair> getHighestPair() {
         var first = getPairs().pollFirst();
         return (first == null) ? Optional.empty() : Optional.of(first);
     }

}
