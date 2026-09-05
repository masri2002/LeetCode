package org.example;

import java.util.ArrayList;
import java.util.List;

public class FirstStableIndex {
    public int firstStableIndex(int[] nums, int k) {
        List<Integer> integerList = new ArrayList<>();
        int maxElement = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            maxElement = Math.max(maxElement, nums[i]);
            int minElement = Integer.MAX_VALUE;

            for (int j = i ; j < nums.length; j++) {
                minElement = Math.min(minElement, nums[j]);
            }
            integerList.add(maxElement - minElement);
        }
        for (int i = 0; i < integerList.size(); i++) {
            if (integerList.get(i) <= k) {
                return i;
            }
        }
        return -1;
    }

    public int firstStableIndexOpt(int[] nums, int k) {
        int n=nums.length;
        int[] right=new int[n];
        right[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            right[i]=Math.min(right[i+1],nums[i]);
        }
        int left=0;
        for(int i=0;i<n;i++){
            left=Math.max(left,nums[i]);
            if(left-right[i]<=k){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstStableIndex firstStableIndex = new FirstStableIndex();
        int[] nums = new int[]{5,0,1,4};
        int k = 3;
        System.out.println(firstStableIndex.firstStableIndex(nums, k));
    }
}
