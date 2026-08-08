package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FindMissingElements {
    public List<Integer> findMissingElements(int[] nums) {
      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;
        for (int x : nums) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        int[] arr = new int[max+1];
        for (int x : nums) {
            arr[x]++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (arr[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindMissingElements findMissingElements = new FindMissingElements();
        List<Integer> list = findMissingElements.findMissingElements(new int[]{5,1});
        System.out.println(list);
    }
}
