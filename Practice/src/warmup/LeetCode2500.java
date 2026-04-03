package Practice.src.warmup;

import java.util.*;

public class LeetCode2500 {

    public static void main(String[] args) {

        LeetCode2500 test = new LeetCode2500();
        int[][] grid = {{1,2,4},{3,3,1}};
        int ans = test.deleteGreatestValue3(grid);
        System.out.println(ans);
    }

    public int deleteGreatestValue(int[][] grid) {

        int r = grid.length;
        int c = grid[0].length;
        int ans = 0;
        for (int k = 0; k < c; k++) {
            int[][] maxArr = new int[r][2];
            for (int i = 0; i < r; i++) {
                int maxEle = Integer.MIN_VALUE;
                int index = -1;
                for (int j = 0; j < c; j++) {
                    if (maxEle < grid[i][j]) {
                        maxEle = grid[i][j];
                        index = j;
                    }
                }
                maxArr[i] = new int[]{maxEle, index};
            }
            int overallMax = Integer.MIN_VALUE;
            for (int i = 0; i < maxArr.length; i++) {
                overallMax = Math.max(overallMax, maxArr[i][0]);
            }
            ans += overallMax;
            for (int i = 0; i < maxArr.length; i++) {
                int index = maxArr[i][1];
                grid[i][index] = Integer.MIN_VALUE;
            }
        }
        return ans;
    }

    public int deleteGreatestValue2(int[][] grid) {

        int r = grid.length;
        int c = grid[0].length;
        int ans = 0;
        for (int i = 0; i < r; i++) {
            Arrays.sort(grid[i]);
        }
        for (int i = c - 1; i >= 0; i--) {
            int maxEle = Integer.MIN_VALUE;
            for (int j = 0; j < r; j++) {
                maxEle = Math.max(maxEle, grid[j][i]);
            }
            ans += maxEle;
        }
        return ans;
    }

    public int deleteGreatestValue3(int[][] grid) {

        int r = grid.length;
        int c = grid[0].length;
        int ans = 0;
        List<PriorityQueue<Integer>> maxHeaps = new ArrayList<>(r);
        for (int i = 0; i < r; i++) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            for (int j = 0; j < c; j++) {
                maxHeap.offer(grid[i][j]);
            }
            maxHeaps.add(maxHeap);
        }
        for (int j = 0; j < c; j++) {
            int maxEle = Integer.MIN_VALUE;
            for (int i = 0; i < r; i++) {
                PriorityQueue<Integer> maxHeap = maxHeaps.get(i);
                maxEle = Math.max(maxEle, maxHeap.poll());
            }
            ans += maxEle;
        }
        return ans;
    }
}
