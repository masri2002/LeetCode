package org.example;

import java.util.Arrays;

public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        int numOfChildren = g.length;
        int numOfSweets = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int p1 = 0;
        int p2;
        int res = 0;
        while (p1 < numOfChildren) {
            p2 = 0;
            while (p2 < numOfSweets) {
                if (s[p2] >= g[p1]) {
                    res++;
                    s[p2] = -g[p1];
                    break;
                }
                p2++;
            }
            p1++;
        }
        return res;
    }

    public int findContentChildrenOptimal(int[] g, int[] s) {
        int maxs = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] > maxs) {
                maxs = s[i];
            }
        }
        int ming = Integer.MAX_VALUE;
        for (int i = 0; i < g.length; i++) {
            if (g[i] < ming) {
                ming = g[i];
            }
        }
        if (ming > maxs) {
            return 0;
        }
        Arrays.sort(s);
        Arrays.sort(g);
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
                count++;
            }

            j++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] g = {10, 9, 8, 7};
        int[] s = {5, 6, 7, 8};
        FindContentChildren obj = new FindContentChildren();
        System.out.println(obj.findContentChildren(g, s));
    }
}
