package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindEvenNumbers {
    public int[] findEvenNumbers(int[] nums) {
        int[] count = new int[10];
        for (int num : nums) {
            count[num]++;
        }
        Set<Integer> set = new HashSet<>();
        backtrack(count, set, 0, 0);
        int[] res = new int[set.size()];
        int i = 0;
        for (int num : set) {
            res[i++] = num;
        }
        Arrays.sort(res);
        return res;
    }

    private void backtrack(int[] count, Set<Integer> set, int curr, int pos) {
        if (pos == 3) {
            if (curr % 2 == 0) {
                set.add(curr);
            }
            return;
        }
        for (int dig = 0; dig <= 9; dig++) {
            if (count[dig] == 0) continue;

            if (pos == 0 && dig == 0) continue;
            count[dig]--;
            int val = curr * 10;
            backtrack(count, set, val + dig, pos + 1);
            count[dig]++;
        }
    }

}
