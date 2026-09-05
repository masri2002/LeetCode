package org.example;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complement = new HashMap<>();
        for (int i = 0; i < nums.length;) {
            int comp = target - nums[i];
            if (complement.containsKey(comp)) {
                return new int[]{complement.get(comp), i};
            }
            complement.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(twoSum.twoSum(new int[]{3,4,5,6},7));
    }
}
