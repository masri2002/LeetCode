package org.example;

public class judgeCircle {
    public boolean judgeCircle(String moves) {
        int[] pos = {0, 0};
        for (char s : moves.toCharArray()) {
            if (s == 'U') {
                pos[0]++;
            } else if (s == 'D') {
                pos[0]--;
            } else if (s == 'L') {
                pos[1]++;
            } else if (s == 'R') {
                pos[0]--;
            }
        }
        for (int i : pos) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        judgeCircle circle = new judgeCircle();
        System.out.println(circle.judgeCircle("LL"));
    }
}
