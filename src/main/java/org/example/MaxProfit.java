package org.example;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int r = i + 1;
            while (r <= prices.length - 1) {
                if (prices[r] - prices[i] > max) {
                    max = prices[r] - prices[i];
                }
                r++;
            }
        }
        return Math.max(max, 0);
    }

    public int maxProfitDb(int[] prices) {
        if (prices.length == 0) return 0;

        int[] dp = new int[prices.length];
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
        }

        return dp[prices.length - 1];
    }

    public int maxProfitOpt(int[] prices) {
        if (prices.length == 0) return 0;

        int max = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            max = Math.max(max, prices[i] - minPrice);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxProfit maxProf = new MaxProfit();
        System.out.println(maxProf.maxProfitOpt(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
