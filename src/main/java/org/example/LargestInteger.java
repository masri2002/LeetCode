package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestInteger {
    public int largestInteger(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        if(k==nums.length){
            return Arrays.stream(nums).max().getAsInt();
        }
        for (int i = 0; i <= nums.length - k; i++) {
            int[] ar = Arrays.copyOfRange(nums, i, i + k);
            for (int value : ar) {
                map.put(value, map.getOrDefault(value, 0) + 1);

            }
        }
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (map.get(entry.getKey()) == 1) {
                max = Math.max(max, entry.getKey());
            }
        }
        return max == Integer.MIN_VALUE ? -1 : max;
    }

    public static void main(String[] args) {
        LargestInteger largestInteger = new LargestInteger();
        System.out.println(largestInteger.largestInteger(new int[]{0,0}, 1));
    }
}
