package org.codingdojo.yatzy1;

import org.codingdojo.yatzy1.scoring.dice.ImmutableRoll;
import org.codingdojo.yatzy1.scoring.strategies.impl.*;
import org.codingdojo.yatzy1.scoring.strategies.impl.numbers.FoursStrategy;
import org.codingdojo.yatzy1.scoring.strategies.impl.numbers.OnesStrategy;
import org.codingdojo.yatzy1.scoring.strategies.impl.numbers.ThreesStrategy;
import org.codingdojo.yatzy1.scoring.strategies.impl.numbers.TwosStrategy;

public class Yatzy1 {

    public static int yatzy(int d1, int d2, int d3, int d4, int d5) {
        var roll = new ImmutableRoll(d1, d2, d3, d4, d5);
        return new YatzyStrategy().getScore(roll);
    }

    public static int ones(int d1, int d2, int d3, int d4, int d5) {
        var roll = new ImmutableRoll(d1, d2, d3, d4, d5);
        return new OnesStrategy().getScore(roll);
    }

    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        var roll = new ImmutableRoll(d1, d2, d3, d4, d5);
        return new TwosStrategy().getScore(roll);
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        var roll = new ImmutableRoll(d1, d2, d3, d4, d5);
        return new ThreesStrategy().getScore(roll);
    }

    protected int[] dice;
    public Yatzy1() {}
    public Yatzy1(int d1, int d2, int d3, int d4, int _5)
    {
        this();
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = _5;
    }

    public int fours() {
        var roll = new ImmutableRoll(dice[0], dice[1], dice[2], dice[3], dice[4]);
        return new FoursStrategy().getScore(roll);
    }

    public int fives()
    {
        int s = 0;
        int i;
        for (i = 0; i < dice.length; i++)
            if (dice[i] == 5)
                s = s + 5;
        return s;
    }

    public int sixes()
    {
        int sum = 0;
        for (int at = 0; at < dice.length; at++)
            if (dice[at] == 6)
                sum = sum + 6;
        return sum;
    }

    public int score_pair(int d1, int d2, int d3, int d4, int d5) {
        var roll = new ImmutableRoll(d1, d2, d3, d4, d5);
        return new PairStrategy().getScore(roll);
    }

    public static int two_pair(int d1, int d2, int d3, int d4, int d5) {
        var roll = new ImmutableRoll(d1, d2, d3, d4, d5);
        return new TwoPairStrategy().getScore(roll);
    }

    public static int four_of_a_kind(int d1, int d2, int d3, int d4, int d5) {
        var roll = new ImmutableRoll(d1, d2, d3, d4, d5);
        return new FourOfAKindStrategy().getScore(roll);
    }

    public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5) {
        var roll = new ImmutableRoll(d1, d2, d3, d4, d5);
        return new ThreeOfAKindStrategy().getScore(roll);
    }


    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        var roll = new ImmutableRoll(d1, d2, d3, d4, d5);
        return new SmallStraightStrategy().getScore(roll);
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        var roll = new ImmutableRoll(d1, d2, d3, d4, d5);
        return new LargeStraightStrategy().getScore(roll);
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        var roll = new ImmutableRoll(d1, d2, d3, d4, d5);
        return new FullHouseStrategy().getScore(roll);
    }
}



