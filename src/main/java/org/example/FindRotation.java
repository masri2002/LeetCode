package org.example;

import java.util.Arrays;

public class FindRotation {

    public static int[][] rotate(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int[][] rotated = new int[c][r];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                rotated[j][r - 1 - i] = mat[i][j];
            }
        }
        return rotated;
    }

    public static boolean findRotation(int[][] mat, int[][] target) {
        int[][] current = mat;
        for (int k = 0; k < 4; k++) {
            if (Arrays.deepEquals(current, target)) {
                return true;
            }
            current = rotate(current);
        }
        return false;
    }

    public static void main(String[] args) {
        boolean result = findRotation(
                new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}},
                new int[][]{{1, 1, 1}, {0, 1, 0}, {0, 0, 0}}
        );
        System.out.println(result); // true
    }
}