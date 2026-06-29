package org.example;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> ballonFreq = new HashMap<>();
        for (char c : "balon".toCharArray()) {
            ballonFreq.put(c, 0);
        }
        int lCount = 0;
        int oCount = 0;

        for (char c : text.toCharArray()) {

            if ("ballon".indexOf(c) != -1) {

                if (c == 'l') {
                    lCount++;

                    if (lCount == 2) {
                        ballonFreq.put('l', ballonFreq.getOrDefault('l', 0) + 1);
                        lCount = 0;
                    }

                } else if (c == 'o') {
                    oCount++;
                    if (oCount == 2) {
                        ballonFreq.put('o', ballonFreq.getOrDefault('o', 0) + 1);
                        oCount = 0;
                    }
                } else {
                    ballonFreq.put(c, ballonFreq.getOrDefault(c, 0) + 1);
                }
            }
        }
        int mostMax = Integer.MAX_VALUE;
        for (int i : ballonFreq.values()) {
            mostMax = Math.min(mostMax, i);
        }
        System.out.println(ballonFreq);
        return mostMax;
    }


    public int maxNumberOfBalloonsOpt(String text) {
        int b = 0, a = 0, l = 0, o = 0, n = 0;
        for (char c : text.toCharArray()) {
            switch (c) {
                case 'b':
                    b++;
                    break;
                case 'a':
                    a++;
                    break;
                case 'l':
                    l++;
                    break;
                case 'o':
                    o++;
                    break;
                case 'n':
                    n++;
            }
        }
        o = o / 2;
        l = l / 2;
        int min = Math.min(a, b);
        min = Math.min(min, l);
        min = Math.min(min, o);
        return Math.min(min,n);
    }

    public static void main(String[] args) {
        System.out.println("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJUZXN0IEFwcGxpY2F0aW9uIiwidXNlcm5hbWUiOiJhaG1hZG1tYXNycmkxQGdtYWlsLmNvbSIsInRva2VuVHlwZSI6IkFDQ0VTUyIsInR2IjozLCJhdXRob3JpdGllcyI6IlJPTEVfQ0xJTklDX09XTkVSIiwiY2xpbmljSWQiOjI0LCJpYXQiOjE3ODIxNTUyOTIsImV4cCI6MTc4MjE1NzA5Mn0.FRjhuIsWQZoXEjtOZooE9ENDAsAxXiHMxlo6EW4t1hQ"
                .equals("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJUZXN0IEFwcGxpY2F0aW9uIiwidXNlcm5hbWUiOiJhaG1hZG1tYXNycmkxQGdtYWlsLmNvbSIsInRva2VuVHlwZSI6IkFDQ0VTUyIsInR2IjoyLCJhdXRob3JpdGllcyI6IlJPTEVfQ0xJTklDX09XTkVSIiwiY2xpbmljSWQiOjI0LCJpYXQiOjE3ODIxNTM1NTEsImV4cCI6MTc4MjE1NTM1MX0.TpnFOxIpwnWY04w2aA8h7L2pvtTzfwrYCIb4fU9TbxQ"));
    }
}
