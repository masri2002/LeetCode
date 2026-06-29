package org.example;

import java.util.Arrays;

public class MaximumElementAfterDecrementingAndRearranging {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0]=1;
        if (arr.length == 1) {
            return arr[0];
        }
        for (int i = 1; i < arr.length; i++) {
            if (!(Math.abs(arr[i] - arr[i - 1]) <= 1)) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        return arr[arr.length - 1];
    }


    private static final int MAXN = 100000;
    private static int[] freqs = new int[MAXN];

    public int maximumElementAfterDecrementingAndRearrangingOpt(int[] arr) {
        final int n = arr.length;
        if (n == 1) return 1;
        for (int v : arr) {
            if (v <= n) freqs[v - 1]++;
        }
        int maxe = n, c = -1;
        for (int v = 0; v < maxe; v++) {
            c += freqs[v];
            if (c > v) {
                maxe -= c - v;
                c = v;
            }
            freqs[v] = 0;
        }
        Arrays.fill(freqs, maxe, n, 0);
        return maxe;
    }

    public static void main(String[] args) {
        MaximumElementAfterDecrementingAndRearranging maximumElementAfterDecrementingAndRearranging = new MaximumElementAfterDecrementingAndRearranging();
        System.out.println(maximumElementAfterDecrementingAndRearranging.maximumElementAfterDecrementingAndRearrangingOpt(new int[]{100,1,1000}));
    }
}
