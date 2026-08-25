package org.example;

public class StoneGameIX {

    public boolean stoneGameIX(int[] stones) {
        int[] cnt = new int[4];
        for (int stone : stones) {
            cnt[stone % 3]++;
        }
        if (cnt[1] == 0) {
            return false;
        }
        int[] ar1 = {cnt[0], cnt[1], cnt[2]};
        int[] ar2 = {cnt[0], cnt[2], cnt[1]};
        return check(ar1) || check(ar2);
    }

    private boolean check(int[] count) {
        count[1]--;
        if (count[1] < 0) {
            return false;
        }
        int tt = 1 + Math.min(count[1], count[2]) * 2 + count[0];
        if (count[1] > count[2]) {
            count[1]--;
            tt++;
        }
        return tt % 2 == 1 && count[1] != count[2];
    }

}
