package org.codingdojo.yatzy1;

import org.codingdojo.yatzy1.scoring.dice.ImmutableRoll;
import org.codingdojo.yatzy1.scoring.strategies.impl.*;

public class Yatzy1 {

    public static int yatzy(int d1, int d2, int d3, int d4, int d5) {
        return new ImmutableRoll(d1, d2, d3, d4, d5).isDeterministic() ? 50 : 0;
    }

    public static int ones(int d1, int d2, int d3, int d4, int d5) {
        int sum = 0;
        if (d1 == 1) sum++;
        if (d2 == 1) sum++;
        if (d3 == 1) sum++;
        if (d4 == 1) sum++;
        if (d5 == 1)
            sum++;

        return sum;
    }

    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        int sum = 0;
        if (d1 == 2) sum += 2;
        if (d2 == 2) sum += 2;
        if (d3 == 2) sum += 2;
        if (d4 == 2) sum += 2;
        if (d5 == 2) sum += 2;
        return sum;
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        int s;
        s = 0;
        if (d1 == 3) s += 3;
        if (d2 == 3) s += 3;
        if (d3 == 3) s += 3;
        if (d4 == 3) s += 3;
        if (d5 == 3) s += 3;
        return s;
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

    public int fours()
    {
        int sum;
        sum = 0;
        for (int at = 0; at != 5; at++) {
            if (dice[at] == 4) {
                sum += 4;
            }
        }
        return sum;
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

    public static int four_of_a_kind(int _1, int _2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[_1-1]++;
        tallies[_2-1]++;
        tallies[d3-1]++;
        tallies[d4-1]++;
        tallies[d5-1]++;
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 4)
                return (i+1) * 4;
        return 0;
    }

    public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5)
    {
        int[] t;
        t = new int[6];
        t[d1-1]++;
        t[d2-1]++;
        t[d3-1]++;
        t[d4-1]++;
        t[d5-1]++;
        for (int i = 0; i < 6; i++)
            if (t[i] >= 3)
                return (i+1) * 3;
        return 0;
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



