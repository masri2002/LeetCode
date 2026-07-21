package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountCompleteComponents {
    boolean[] visited;
    Map<Integer, List<Integer>> graph;

    public int countCompleteComponents(int n, int[][] edges) {
        int res = 0;
        graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        visited = new boolean[n];
        for (int node = 0; node < n; ++node) {
            if (!visited[node]) {
                int[] componentStats = dfs(node);
                int nodeCount = componentStats[0];
                int edgeCount = componentStats[1];

                if (nodeCount * (nodeCount - 1) == edgeCount) {
                    ++res;
                }
            }
        }
        return res;
    }

    public int[] dfs(int i) {
        visited[i] = true;
        int nodeCount = 1;
        int dgreeCount = graph.get(i).size();
        for (int x : graph.get(i)) {
            if (!visited[x]) {
                int[] next = dfs(x);
                nodeCount += next[0];
                dgreeCount += next[1];
            }
        }
        return new int[]{nodeCount, dgreeCount};
    }

    public static void main(String[] args) {
        CountCompleteComponents completeComponents = new CountCompleteComponents();
        System.out.println(completeComponents.countCompleteComponents(6, new int[][]{{0, 1}, {0, 2}, {1, 2}, {3, 4}}));
    }
}
