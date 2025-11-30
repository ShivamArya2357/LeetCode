package Practice.src.warmup;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode200 {

    public static void main(String[] args) {

    }

    public int numIslands(char[][] grid) {

        int R = grid.length;
        int C = grid[0].length;
        int ans = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, R, C, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int R, int C, int i, int j) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        grid[i][j] = '0';
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int x = top[0];
            int y = top[1];
            if (y + 1 < C && grid[x][y + 1] == '1') {
                queue.add(new int[]{x, y + 1});
                grid[x][y + 1] = '0';
            }
            if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                queue.add(new int[]{x, y - 1});
                grid[x][y - 1] = '0';
            }
            if (x + 1 < R && grid[x + 1][y] == '1') {
                queue.add(new int[]{x + 1, y});
                grid[x + 1][y] = '0';
            }
            if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                queue.add(new int[]{x - 1, y});
                grid[x - 1][y] = '0';
            }
        }
    }
}
