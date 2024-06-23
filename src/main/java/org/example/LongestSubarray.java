package org.example;

import java.util.*;

public class LongestSubarray {


    public int longestSubarray(int[] nums, int limit) {
        ArrayDeque<Integer> arrayInc = new ArrayDeque<>();
        ArrayDeque<Integer> arrayDec = new ArrayDeque<>();
        int res=0;
         int j=0;
        for (int i = 0; i < nums.length; i++) {
            while(!arrayInc.isEmpty() && arrayInc.getLast()>nums[i]){
                arrayInc.removeLast();
            }
            arrayInc.addLast(nums[i]);
            while(!arrayDec.isEmpty() && arrayDec.getLast()<nums[i]){
                arrayDec.removeLast();
            }
            arrayDec.addLast(nums[i]);
            while(!arrayDec.isEmpty() &&arrayDec.getFirst()-arrayInc.getFirst()>limit){
                if(arrayInc.getFirst()==nums[j]){
                    arrayInc.removeFirst();
                }
                if(arrayDec.getFirst()==nums[j]){
                    arrayDec.removeFirst();
                }
                j++;
            }
            res = Math.max(res,i-j+1);
        }

        return res;

    }
}
