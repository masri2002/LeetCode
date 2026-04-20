package org.example;

public class MaxDistance {
    public int maxDistance(int[] colors) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < colors.length; i++) {
            count =0;
            for (int j = i + 1; j < colors.length; j++) {
                if (colors[i] != colors[j]) {
                    count++;
                    max = Math.max(max, count);
                } else
                    count++;
            }
        }
        return Math.max(max, count);
    }

        public int maxDistance2(int[] col) { // optimal solution , max always in the middle of the array so that i must check the current with the end and start to get maximize distance
            int n = col.length;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (col[i] != col[0]) {
                    ans = Math.max(ans,i);
                }
                if (col[i] != col[n - 1]) {
                    ans = Math.max(ans, (n - i - 1));
                }
            }
            return ans;
        }
    }

