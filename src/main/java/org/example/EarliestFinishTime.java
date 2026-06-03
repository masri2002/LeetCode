package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EarliestFinishTime {
    public int earliestFinishTime(
            int[] landStartTime,
            int[] landDuration,
            int[] waterStartTime,
            int[] waterDuration) {

        List<Pair<Integer, Integer>> landTimes = new ArrayList<>();
        List<Pair<Integer, Integer>> waterTimes = new ArrayList<>();

        for (int i = 0; i < landStartTime.length; i++) {
            landTimes.add(new Pair<>(
                    landStartTime[i],
                    landStartTime[i] + landDuration[i]
            ));
        }

        for (int i = 0; i < waterStartTime.length; i++) {
            waterTimes.add(new Pair<>(
                    waterStartTime[i],
                    waterStartTime[i] + waterDuration[i]
            ));
        }

        int n = landTimes.size();
        int m = waterTimes.size();

        int[] landEnds = new int[n];
        int[] waterEnds = new int[m];

        int minLandEnd = Integer.MAX_VALUE;
        int minWaterEnd = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            landEnds[i] = landTimes.get(i).end;
            minLandEnd = Math.min(minLandEnd, landEnds[i]);
        }

        for (int i = 0; i < m; i++) {
            waterEnds[i] = waterTimes.get(i).end;
            minWaterEnd = Math.min(minWaterEnd, waterEnds[i]);
        }

        Arrays.sort(landEnds);
        Arrays.sort(waterEnds);

        int earliestFinish = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            Pair<Integer, Integer> water = waterTimes.get(i);

            int bestStart;
            if (hasEndBefore(landEnds, water.start)) {
                bestStart = water.start;
            } else {
                bestStart = minLandEnd;
            }

            int finish = bestStart + (water.end - water.start);
            earliestFinish = Math.min(earliestFinish, finish);
        }

        for (int i = 0; i < n; i++) {
            Pair<Integer, Integer> land = landTimes.get(i);

            int bestStart;
            if (hasEndBefore(waterEnds, land.start)) {
                bestStart = land.start;
            } else {
                bestStart = minWaterEnd;
            }

            int finish = bestStart + (land.end - land.start);
            earliestFinish = Math.min(earliestFinish, finish);
        }

        return earliestFinish;
    }

    private boolean hasEndBefore(int[] arr, int target) {
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (arr[mid] <= target) {
                return true;
            }

            if (arr[mid] > target) {
                r = mid - 1;
            }
        }

        return false;
    }

    class Pair<T, T1> {
        int start;
        int end;

        public Pair(int val1, int val2) {
            this.start = val1;
            this.end = val2;
        }
    }
}
