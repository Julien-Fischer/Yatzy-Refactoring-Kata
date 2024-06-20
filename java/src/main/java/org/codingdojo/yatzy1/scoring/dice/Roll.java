package org.codingdojo.yatzy1.scoring.dice;

 /**
 * A roll is the result of throwing one or more dice simultaneously.
 * In Yatzy specifically, a roll is defined as a set of five six-faced dice.
 */
public interface Roll {

     /**
      * @return the sum of the dice in this roll.
      */
     int getSum();

}
