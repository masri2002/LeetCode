package org.example;

public class SmallestPalindrome {
    public String smallestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        if (s.length() == 2) {
            return s;
        }
        if (s.length() == 3 && s.charAt(0) == s.charAt(2)) {
            return s;
        }
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        StringBuilder left = new StringBuilder();
        StringBuilder mid = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            int repeat = freq[i] / 2;
            left.repeat(String.valueOf((char) ('a' + i)), Math.max(0, repeat));
            if (freq[i] % 2 == 1) {
                mid.append((char) ('a' + i));
            }
        }
        String right = new StringBuilder(left).reverse().toString();
        return left.toString() + mid + right;
    }

    public static void main(String[] args) {
        SmallestPalindrome sm = new SmallestPalindrome();
        System.out.println(sm.smallestPalindrome("abbaccc"));
    }
}
