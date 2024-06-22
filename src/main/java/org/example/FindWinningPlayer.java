package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class FindWinningPlayer {
    public int findWinningPlayer(int[] skills, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : skills) {
            list.add(num);
        }
        if (k >= skills.length) {
            return list.indexOf(Arrays.stream(skills).max().getAsInt());
        }
        int winCount = 0;
        int currentWinner = list.get(0);
        int currentIndex = 0;

        for (int i = 1; i < list.size(); i++) {
            if (currentWinner > list.get(i)) {
                winCount++;
            } else {
                currentWinner = list.get(i);
                winCount = 1;
                currentIndex = i;
            }

            if (winCount == k) {
                return currentIndex;
            }
        }

        return currentIndex;
    }
}
