package Practice.src.warmup;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode2658 {

    static class UF {

        private int[] parent;
        private int[] rank;

        public UF(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {

            if (parent[x] == x) {
                return x;
            }
            return find(parent[x]);
        }

        public void union(int x, int y) {

            int parent1 = find(x);
            int parent2 = find(y);
            if (parent1 == parent2) {
                return;
            } else if (rank[parent1] < rank[parent2]) {
                parent[parent1] = parent2;
            } else if (rank[parent1] > rank[parent2]) {
                parent[parent2] = parent1;
            } else {
                parent[parent1] = parent2;
                rank[parent2]++;
            }
        }
    }

    public static void main(String[] args) {

        LeetCode2658 test = new LeetCode2658();
        int[][] grid = {{0,2,1,0},{4,0,0,3},{1,0,0,4},{0,3,2,0}};
        int ans = test.findMaxFish(grid);
        System.out.println(ans);
    }

//    public int findMaxFish(int[][] grid) {
//
//        int R = grid.length;
//        int C = grid[0].length;
//        int maxFishCount = 0;
//        for (int i = 0; i < R; i++) {
//            for (int j = 0; j < C; j++) {
//                if (grid[i][j] > 0) {
//                    maxFishCount = Math.max(maxFishCount, dfs(grid, R, C, i, j));
//                }
//            }
//        }
//        return maxFishCount;
//    }

    public int findMaxFish(int[][] grid) {

        int R = grid.length;
        int C = grid[0].length;
        UF uf = new UF(R * C);
        int[][] direction = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] > 0) {
                    int ceilIndex = i * C + j;
                    for (int k = 0; k < 4; k++) {
                        int x = i + direction[k][0];
                        int y = j + direction[k][1];
                        if (x >= 0 && x < R && y >= 0 && y < C && grid[x][y] > 0) {
                            int neighbourIndex = x * C + y;
                            uf.union(ceilIndex, neighbourIndex);
                        }
                    }
                }
            }
        }
        int[] totalFish = new int[R * C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] > 0) {
                    int ceilIndex = i * C + j;
                    int root = uf.find(ceilIndex);
                    totalFish[root] += grid[i][j];
                }
            }
        }
        return Arrays.stream(totalFish).max().getAsInt();
    }

    private int dfs(int[][] grid, int R, int C, int i, int j) {

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i, j});
        int fishCount = grid[i][j];
        grid[i][j] = 0;
        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            int x = top[0];
            int y = top[1];
            if (y - 1 >= 0 && grid[x][y - 1] > 0) {
                stack.push(new int[]{x, y - 1});
                fishCount += grid[x][y - 1];
                grid[x][y - 1] = 0;
            }
            if (y + 1 < C && grid[x][y + 1] > 0) {
                stack.push(new int[]{x, y + 1});
                fishCount += grid[x][y + 1];
                grid[x][y + 1] = 0;
            }
            if (x - 1 >= 0 && grid[x - 1][y] > 0) {
                stack.push(new int[]{x - 1, y});
                fishCount += grid[x - 1][y];
                grid[x - 1][y] = 0;
            }
            if (x + 1 < R && grid[x + 1][y] > 0) {
                stack.push(new int[]{x + 1, y});
                fishCount += grid[x + 1][y];
                grid[x + 1][y] = 0;
            }
        }
        return fishCount;
    }
}
