package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinElement {
    public int minElement(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int index = 0;
        for (int i : nums) {
            while (i > 0) {
                int x = i % 10;
                List<Integer> list = map.getOrDefault(index, new ArrayList<>());
                list.add(x);
                map.put(index, list);
                i = i / 10;
            }
            index++;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < map.size(); i++) {
            int sum = 0;
            for (int j = 0; j < map.get(i).size(); j++) {
                sum += map.get(i).get(j);
            }
            min = Math.min(min, sum);
        }
        return min;
    }

    public int minElementOptimal(int[] nums) {
        int min = 454564544;
        for (int i : nums) {
            int sum = 0;
            while (i > 0) {
                sum += i % 10;
                i /= 10;
            }
            min = Math.min(min, sum);
        }
        return min;
    }

    public static void main(String[] args) {
        MinElement minElement = new MinElement();
        int[] nums = {999,19,199};
        System.out.println(minElement.minElement(nums));
    }
}
