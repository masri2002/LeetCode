package org.example;

public class rotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = t;
            }
        }
    }

    public static void main(String[] args) {
        rotateImage rotateImage = new rotateImage();
        rotateImage.rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }
}
