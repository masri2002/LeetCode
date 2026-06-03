package org.example;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCost {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int res=0;
        for (int i=cost.length-1;i>=0;i-=3){
            res+=cost[i];
            if (i-1>=0){
                res+=cost[i-1];
            }
        }
     return res;
    }

    public int minimumCostOptimal(int[] cost) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int c : cost) {
            pq.add(c);
        }
        int res = 0;
        for (int i = 0; !pq.isEmpty(); i++) {
            int c = pq.poll();
            if (i % 3 != 2) {
                res += c;
            }
        }
     return res;
    }

    public static void main(String[] args) {
        MinimumCost minimumCost = new MinimumCost();
        int res = minimumCost.minimumCostOptimal(new int[]{6,5,7,9,2,2});
        System.out.println(res);
    }
}
