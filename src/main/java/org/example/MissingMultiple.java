package org.example;

import java.util.Arrays;

public class MissingMultiple {
    public int missingMultiple(int[] nums, int k) {
        boolean[] exsited = new boolean [101];
        for (int num : nums) {
            exsited[num] = true;
        }
        for (int i = 1; i < 100; i++) {
            if (!exsited[i*k]) {
                return i*k;
            }
        }
        return -1;
    }
}
