package org.example;

import java.util.*;

public class FindSafeWalk {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int rows = grid.size();
        int cols = grid.get(0).size();
        int[][] dist = new int[rows][cols];
        for (int ar[] : dist)
            Arrays.fill(ar, Integer.MAX_VALUE);
        if (grid.get(0).get(0) == 1) {
            dist[0][0] = 1;
        } else {
            dist[0][0] = 0;
        }
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});

        final int[] directions = {-1, 0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int[] currentPosition = queue.poll();
            int currentRow = currentPosition[0];
            int currentCol = currentPosition[1];

            for (int i = 0; i < directions.length - 1; i++) {
                int nextRow = currentRow + directions[i];
                int nextCol = currentCol + directions[i + 1];
                if (nextRow >= 0 && nextRow < rows &&
                        nextCol >= 0 && nextCol < cols &&
                        dist[nextRow][nextCol] > dist[currentRow][currentCol] + grid.get(nextRow).get(nextCol)) {

                    dist[nextRow][nextCol] = dist[currentRow][currentCol] + grid.get(nextRow).get(nextCol);

                    queue.offer(new int[]{nextRow, nextCol});
                }
            }

        }
        return dist[rows - 1][cols - 1] < health;
    }

    public static void main(String[] args) {
        FindSafeWalk safeWalk = new FindSafeWalk();
        List<List<Integer>> list = new ArrayList<>(Arrays.asList(
                Arrays.asList(1, 1, 1, 1)
        ));
        System.out.println(safeWalk.findSafeWalk(list, 4));
    }
}
