package org.example;

public class UniformArray {
    public boolean uniformArray(int[] nums1) {
        int sallestEven = Integer.MAX_VALUE;
        for (int j : nums1) {
            if (j % 2 != 0) {
                sallestEven = Math.min(sallestEven, j);
            }
        }
        if (sallestEven == Integer.MAX_VALUE) {
            return true;
        }
        for (int x : nums1) {
            if (x % 2 == 0 && x < sallestEven) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        UniformArray uniformArray = new UniformArray();
        System.out.println(uniformArray.uniformArray(new int[]{2,3}));
    }
}
