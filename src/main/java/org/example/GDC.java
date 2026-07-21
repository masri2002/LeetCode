package org.example;

import java.util.Arrays;

public class GDC {

    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums[nums.length - 1]; i >=1; i--) {
            int max = nums[nums.length-1];
            int min = nums[0];
            if (max %i==0 && min %i==0){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        GDC gdc = new GDC();
        System.out.println(gdc.findGCD(new int[]{3,3}));
    }
}
