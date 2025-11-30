package Practice.src.warmup;

import java.util.*;

public class LeetCode1584 {

    public static void main(String[] args) {

    }

//    public int minCostConnectPoints(int[][] points) {
//
//        int n = points.length;
//        int totalCost = 0;
//        int[] minCost = new int[n];
//        boolean[] inMST = new boolean[n];
//        Arrays.fill(minCost, Integer.MAX_VALUE);
//        minCost[0] = 0;
//        for (int i = 0; i < n; i++) {
//            int bad = Integer.MAX_VALUE;
//            int u = -1;
//            for (int j = 0; j < n; j++) {
//                if (!inMST[j] && minCost[j] < bad) {
//                    bad = minCost[j];
//                    u = j;
//                }
//            }
//            totalCost += bad;
//            inMST[u] = true;
//            for (int j = 0; j < n; j++) {
//                if (!inMST[j]) {
//                    int dist = Math.abs(points[j][0] - points[u][0]) +
//                            Math.abs(points[j][1] - points[u][1]);
//                    if (minCost[j] > dist) {
//                        minCost[j] = dist;
//                    }
//                }
//            }
//        }
//        return totalCost;
//    }

    public int minCostConnectPoints(int[][] points) {

        int n = points.length;
        int totalCost = 0;
        boolean[] inMST = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Map<Integer, Integer> cache = new HashMap<>();
        pq.offer(new int[]{0, 0});
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            if (inMST[top[1]]) {
                continue;
            }
            inMST[top[1]] = true;
            totalCost += top[0];
            for (int i = 0; i < n; i++) {
                if (!inMST[i]) {
                    int dist = Math.abs(points[top[1]][0] - points[i][0]) + Math.abs(points[top[1]][1] - points[i][1]);
                    if (dist < cache.getOrDefault(i, Integer.MAX_VALUE)) {
                        cache.put(i, dist);
                        pq.offer(new int[]{dist, i});
                    }
                }
            }
        }
        return totalCost;
    }
}
