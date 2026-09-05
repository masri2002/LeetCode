package org.example;

public class MirrorDistance {
    public int mirrorDistance(int n) {
        if (n < 10) {
            return 0;
        }

        int x = n;
        int reverse = 0;
        while (x > 0) {
            reverse *= 10;
            reverse += x % 10;
            x /= 10;
        }
        return Math.abs(n - reverse);
    }

    public static void main(String[] args) {
        MirrorDistance mirrorDistance = new MirrorDistance();
        System.out.println(mirrorDistance.mirrorDistance(25));
    }
}
