package org.example;

import java.util.HashMap;

public class MaximumLengthSubstring {
    public int maximumLengthSubstring(String s) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int j = 0; j < s.length(); j++) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = j; i < s.length(); i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
                if (map.get(s.charAt(i)) > 2) {
                    break;
                } else {
                    count++;
                }
            }
            max = Math.max(max, count);
            count = 0;
        }
        return Math.max(max, count);
    }



    public int maximumLengthSubstringOpt(String s) {
        int[] freq = new int[26];
        int left = 0;
        int max = 0;
        int curlen = 0;
        for(int right = 0;right<s.length();right++){
            freq[s.charAt(right) - 'a']++;
            while(freq[s.charAt(right) - 'a'] > 2){
                freq[s.charAt(left) - 'a']--;
                left++;
            }
            curlen = right-left+1;
            max = Math.max(max,curlen);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumLengthSubstring mls = new MaximumLengthSubstring();
        System.out.println(mls.maximumLengthSubstringOpt("bbbab"));
    }
}
