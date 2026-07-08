package org.example;

import java.util.ArrayList;

public class SumAndMultiply {
    static final long MOD = 1_000_000_007L;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> digits = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                pos.add(i);
                digits.add(d);
            }
        }

        int m = digits.size();

        long[] prefixSum = new long[m + 1];

        long[] prefixValue = new long[m + 1];

        long[] pow10 = new long[m + 1];
        pow10[0] = 1;

        for (int i = 0; i < m; i++) {
            prefixSum[i + 1] = prefixSum[i] + digits.get(i);
            prefixValue[i + 1] = (prefixValue[i] * 10 + digits.get(i)) % MOD;
            pow10[i + 1] = (pow10[i] * 10) % MOD;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            int left = lowerBound(pos, l);
            int right = upperBound(pos, r) - 1;

            if (left > right) {
                ans[i] = 0;
                continue;
            }

            long sum = prefixSum[right + 1] - prefixSum[left];

            int len = right - left + 1;

            long value = (prefixValue[right + 1]
                    - (prefixValue[left] * pow10[len]) % MOD + MOD) % MOD;

            ans[i] = (int) ((value * sum) % MOD);
        }

        return ans;
    }

    private int lowerBound(ArrayList<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (list.get(mid) < target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    private int upperBound(ArrayList<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (list.get(mid) <= target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    public long sumAndMultiply(int n) {
        int indexNot0 = 0;
        int number = 0;
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            if (digit != 0) {
                number += (int) (digit * Math.pow(10, indexNot0++));
            }
            n /= 10;
        }
        return (long) number * sum;
    }

    public static void main(String[] args) {
        SumAndMultiply sumAndMultiply = new SumAndMultiply();
        System.out.println("=" + sumAndMultiply.sumAndMultiply(10203004));
    }
}
