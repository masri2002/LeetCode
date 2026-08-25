package org.example;

public class DivideArray {
    public boolean divideArray(int[] nums) {
        int[] ar = new int[nums.length * 2 + 1];
        for (int i : nums) ar[i] = ar[i] + 1;
        for (int i : nums) {
            if (ar[i] % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
