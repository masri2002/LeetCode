package org.example;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <= 0) return res;
        res.add(List.of(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = res.get(i - 1);
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    int value = prevRow.get(j - 1) + prevRow.get(j);
                    row.add(value);
                }
            }

            res.add(row);
        }

        return res;
    }

    public static void main(String[] args) {
        PascalsTriangle pascalsTriangle = new PascalsTriangle();
        System.out.println(pascalsTriangle.generate(6));
    }
}