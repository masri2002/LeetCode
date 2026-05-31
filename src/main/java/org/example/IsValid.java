package org.example;

public class IsValid {
    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        String update = s.replace("()", "")
                .replace("{}", "")
                .replace("[]", "");
        if (s.length() <= update.length()) {
            return false;
        }
        return isValid(update);
    }
    public int mySqrt(int x) {
        return helper(x, 1, 0);
    }

    private int helper(int x, int odds, int sqrt) {
        if (x < odds) {
            return sqrt;
        }

        return helper(
                x - odds,
                odds + 2,
                sqrt + 1
        );
    }

    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return helper(x, N);
    }

    private double helper(double x, long n) {
        if (n == 0) {
            return 1.0;
        }

        double half = helper(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public static void main(String[] args) {
        IsValid valid = new IsValid();
        System.out.println(valid.myPow(8,-2));
    }
}
