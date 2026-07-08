package org.example;

import java.util.*;

public class MinScore {
    Map<Integer, List<Pair>> graph = new HashMap<>();
    boolean[] vis;
    int min = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {
        vis = new boolean[n];
        Arrays.fill(vis, false);
        vis[0] = true;
        for (int[] i : roads) {
            graph.computeIfAbsent(i[0], k -> new ArrayList<>())
                    .add(new Pair(i[1], i[2]));
            graph.computeIfAbsent(i[1], k -> new ArrayList<>())
                    .add(new Pair(i[0], i[2]));
        }

        dfs(1);
        return min;
    }

    private void dfs(int i) {
        for (int j = 0; j < graph.get(i).size(); j++) {
            Pair nextCity = graph.get(i).get(j);
            min = Math.min(min, nextCity.cost);

            if (!vis[nextCity.to-1]) {
                vis[nextCity.to-1] = true;
                dfs(nextCity.to);
            }
        }
    }


    static class Pair {
        int to;
        int cost;

        public Pair(int a, int b) {
            this.to = a;
            this.cost = b;
        }
    }

    public static void main(String[] args) {
        MinScore solver = new MinScore();

        int[][] roads = {
                {1, 2, 9},
                {2, 3, 6},
                {2, 4, 5},
                {1, 4, 7}
        };

        System.out.println(solver.minScore(4, roads));
    }
}
