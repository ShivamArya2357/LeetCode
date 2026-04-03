package Practice.src.warmup;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1631 {

    public static void main(String[] args) {

        LeetCode1631 test = new LeetCode1631();
        int[][] heights = {{10,8},{10,8},{1,2},{10,3},{1,3},{6,3},{5,2}};
        int ans = test.minimumEffortPath(heights);
        System.out.println(ans);
    }

    public int minimumEffortPath(int[][] heights) {

        int l = 0;
        int h = 0;
        int row = heights.length;
        int col = heights[0].length;
        for (int i = 0; i < row; i++) {
            h = Math.max(h, Arrays.stream(heights[i]).max().getAsInt());
        }
        int ans = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (isPossible(heights, row, col, mid)) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[][] heights, int row, int col, int X) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        boolean[][] visited = new boolean[row][col];
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            if (top[0] == row - 1 && top[1] == col - 1) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int xDir = dir[i][0];
                int yDir = dir[i][1];
                int newXDir = top[0] + xDir;
                int newYDir = top[1] + yDir;
                if (!isInValid(newXDir, newYDir, row, col) && !visited[newXDir][newYDir] &&
                        Math.abs(heights[newXDir][newYDir] - heights[top[0]][top[1]]) <= X
                ) {
                    queue.add(new int[]{newXDir, newYDir});
                    visited[newXDir][newYDir] = true;
                }
            }
        }
        return false;
    }

    private boolean isInValid(int x, int y, int row, int col) {
        return x < 0 || y < 0 || x >= row || y >= col;
    }
}
