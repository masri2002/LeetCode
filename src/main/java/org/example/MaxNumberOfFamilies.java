package org.example;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<String, Boolean> pairs = new HashMap<>();

        Map<Integer, Boolean> rows = new HashMap<>();

        for (int[] reservedSeat : reservedSeats) {
            pairs.put(String.format("%d,%d", reservedSeat[0], reservedSeat[1]), true);
            rows.put(reservedSeat[0], true);
        }

        int res = (n - rows.size()) * 2;

        for (int i : rows.keySet()) {
            if (!pairs.containsKey(String.format("%d,%d", i, 2))
                    && !pairs.containsKey(String.format("%d,%d", i, 3))
                    && !pairs.containsKey(String.format("%d,%d", i, 4))
                    && !pairs.containsKey(String.format("%d,%d", i, 5))) {

                pairs.put(String.format("%d,%d", i, 2), true);
                pairs.put(String.format("%d,%d", i, 3), true);
                pairs.put(String.format("%d,%d", i, 4), true);
                pairs.put(String.format("%d,%d", i, 5), true);

                res++;
            }

            if (!pairs.containsKey(String.format("%d,%d", i, 6))
                    && !pairs.containsKey(String.format("%d,%d", i, 7))
                    && !pairs.containsKey(String.format("%d,%d", i, 8))
                    && !pairs.containsKey(String.format("%d,%d", i, 9))) {

                pairs.put(String.format("%d,%d", i, 6), true);
                pairs.put(String.format("%d,%d", i, 7), true);
                pairs.put(String.format("%d,%d", i, 8), true);
                pairs.put(String.format("%d,%d", i, 9), true);

                res++;
            }

            if (!pairs.containsKey(String.format("%d,%d", i, 4))
                    && !pairs.containsKey(String.format("%d,%d", i, 5))
                    && !pairs.containsKey(String.format("%d,%d", i, 6))
                    && !pairs.containsKey(String.format("%d,%d", i, 7))) {

                pairs.put(String.format("%d,%d", i, 4), true);
                pairs.put(String.format("%d,%d", i, 5), true);
                pairs.put(String.format("%d,%d", i, 6), true);
                pairs.put(String.format("%d,%d", i, 7), true);

                res++;
            }
        }

        return res;
    }
}