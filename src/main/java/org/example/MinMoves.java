package org.example;

public class MinMoves {
    public int minMoves(int[] nums, int limit) {
        int[] diff = new int[2 * limit + 2];
        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            int min = Math.min(nums[i], nums[n - 1 - i]);
            int max = Math.max(nums[i], nums[n - 1 - i]);

            diff[2]+=2;
            diff[min+1]-=2;

            diff[min+1]+=1;
            diff[min+max]-=1;

            diff[min+max+1]+=1;
            diff[max+limit+1]-=1;

            diff[min+limit+1]+=2;
        }

        int minimumMoves = n;
        int prefixSum = 0;
        for (int targetSum = 2; targetSum < diff.length; ++targetSum) {
            prefixSum += diff[targetSum];
            minimumMoves = Math.min(minimumMoves, prefixSum);
        }

        return minimumMoves;
    }

    public static void main(String[] args) {
        MinMoves moves = new MinMoves();
        System.out.println(moves.minMoves(new int[]{1,2,4,3},4));
    }
}
