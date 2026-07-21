package org.example;

import java.util.ArrayList;
import java.util.List;

public class ShiftGrid {
    /*
    Element at grid[i][j] moves to grid[i][j + 1].
    Element at grid[i][n - 1] moves to grid[i + 1][0].
    Element at grid[m - 1][n - 1] moves to grid[0][0].
     */
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] shifted = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i * n + j; // 1d array index
                int newIdx = (idx + k) % (m * n); // (idx+k) num of shift %  (M*N) Circular array  like index 5 and k =1 == 6 not index 6 in array so that the right place is 0 6%6 ==0

                int newRow = newIdx / n; // index 7 is in second row 7/3 = 2
                int newCol = newIdx % n; // index 7 in col 1 7%3 = 1

                shifted[newRow][newCol] = grid[i][j];
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int[] row : shifted) {
            List<Integer> list = new ArrayList<>();
            for (int num : row) {
                list.add(num);
            }
            ans.add(list);
        }

        return ans;
    }

    public static void main(String[] args) {
        ShiftGrid shiftGrid = new ShiftGrid();
        System.out.println(shiftGrid.shiftGrid(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1));
    }
}
