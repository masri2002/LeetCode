package org.example;

public class LargestAltitude {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int sum = 0;
        for (int x : gain) {
            sum = sum + x;
            max = Math.max(max, sum);
        }
        return max;
    }
}
