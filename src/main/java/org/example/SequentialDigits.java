package org.example;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        String digits = "123456789";

        int minLen = String.valueOf(low).length();
        int maxLen = String.valueOf(high).length();

        for (int len = minLen; len <= maxLen; len++) {
            for (int start = 0; start + len <= 9; start++) {
                int num = Integer.parseInt(digits.substring(start, start + len));

                if (num >= low && num <= high) {
                    res.add(num);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        SequentialDigits digits = new SequentialDigits();
        System.out.println(digits.sequentialDigits(1000, 13000));
    }
}
