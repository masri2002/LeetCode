package org.example;

public class MapWordWeights {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder w = new StringBuilder();
        for (String word : words) {
            int weight = 0;
            for (char c : word.toCharArray()) {
                weight += weights[c - 97];
            }
            w.append((char) ('z' - (weight % 26)));
        }
        return w.toString();
    }


    public static void main(String[] args) {
        MapWordWeights mapWordWeights = new MapWordWeights();
        System.out.println(mapWordWeights.mapWordWeights(new String[]{"abcd", "def", "xyz"}, new int[]{5, 3, 12, 14, 1, 2, 3, 2, 10, 6, 6, 9, 7, 8, 7, 10, 8, 9, 6, 9, 9, 8, 3, 7, 7, 2}));

    }
}
