package org.example;

import java.util.ArrayList;

public class SeparateDigits {
    public int[] separateDigits(int[] nums) {
     int totalSize=0;
     for (int i:nums){
         while (i>0){
             totalSize++;
             i/=10;
         }
     }
     int[] res = new int [totalSize];
     int pos=res.length-1;
     for (int i=nums.length-1; i >= 0 ; i--){
         while (nums[i]>0){
             res[pos--]=nums[i]%10;
             nums[i]/=10;
         }
     }
     return res;
    }
}
