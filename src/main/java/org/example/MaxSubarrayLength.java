package org.example;

import java.util.HashMap;
import java.util.Map;

public class MaxSubarrayLength {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while (map.get(nums[j]) > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                i++;
            }
            max = Math.max(max, j - i + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        MaxSubarrayLength maxSubarrayLength = new MaxSubarrayLength();
        System.out.println(maxSubarrayLength.maxSubarrayLength(new int[]{1, 3, 3, 2}, 1));
    }
}
