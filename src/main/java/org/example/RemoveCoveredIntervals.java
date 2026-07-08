package org.example;

import java.util.Arrays;

public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int res = 0, prev = Integer.MIN_VALUE;
        for (int[] ar : intervals) {
            int x = ar[1];
            if (x > prev) {
                res++;
                prev = x;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        RemoveCoveredIntervals coveredIntervals = new RemoveCoveredIntervals();
        System.out.println(coveredIntervals.removeCoveredIntervals(new int[][]{{1, 4}, {3, 6}, {2, 8}}));
    }
}
