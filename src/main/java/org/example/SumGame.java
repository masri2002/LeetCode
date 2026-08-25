package org.example;

public class SumGame {
    public boolean sumGame(String num) {
        final int n = num.length();
        double ans = 0.0;

        for (int i = 0; i < n / 2; ++i)
            ans += getExpectedValue(num.charAt(i));

        for (int i = n / 2; i < n; ++i)
            ans -= getExpectedValue(num.charAt(i));

        return ans != 0.0;
    }

    private double getExpectedValue(char c) {
        return c == '?' ? 4.5 : c - '0';
    }


    public static void main(String[] args) {
        SumGame sumGame = new SumGame();
        System.out.println(sumGame.sumGame("?3295???"));
    }
}
