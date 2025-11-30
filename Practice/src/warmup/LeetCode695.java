package Practice.src.warmup;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LeetCode695 {

    static class UF {

        int[] group, rank;

        public UF(int n) {
            this.group = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                group[i] = i;
            }
        }

        public int find(int x) {

            if (group[x] == x) {
                return x;
            }
            return find(group[x]);
        }

        public void union(int x, int y) {

            int groupLead1 = find(x);
            int groupLead2 = find(y);
            if (groupLead1 == groupLead2) {
                return;
            } else if (rank[groupLead1] < rank[groupLead2]) {
                group[groupLead1] = groupLead2;
            } else if (rank[groupLead2] < rank[groupLead1]) {
                group[groupLead2] = groupLead1;
            } else {
                group[groupLead1] = groupLead2;
                rank[groupLead2]++;
            }
        }
    }

    public static void main(String[] args) {

        LeetCode695 test = new LeetCode695();
        int[][] grid = {{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
        int ans = test.maxAreaOfIsland(grid);
        System.out.println(ans);
    }

//    public int maxAreaOfIsland(int[][] grid) {
//
//        int R = grid.length;
//        int C = grid[0].length;
//        UF uf = new UF(R * C);
//        int count = 0;
//        for (int i = 0; i < R; i++) {
//            for (int j = 0; j < C; j++) {
//                if (grid[i][j] == 1) {
//                    if (count - 1 >= 0 && (count - 1) % C == (j - 1) && grid[i][(count - 1) % C] == 1) {
//                        uf.union(count, count - 1);
//                    }
//                    if (i - 1 >= 0 && grid[i - 1][count % C] == 1) {
//                        int newCount = 0;
//                        if (i - 2 >= 0) {
//                            newCount += C * (i - 1);
//                        }
//                        uf.union(count, newCount +  count % C);
//                    }
//                }
//                count++;
//            }
//        }
//        int[] edgeCount = new int[count];
//        count = 0;
//        for (int i = 0; i < R; i++) {
//            for (int j = 0; j < C; j++) {
//                if (grid[i][j] == 1) {
//                    int root = uf.find(count);
//                    edgeCount[root]++;
//                }
//                count++;
//            }
//        }
//        int ans = Arrays.stream(edgeCount).max().getAsInt();
//        return ans;
//    }

    public int maxAreaOfIsland(int[][] grid) {

        int R = grid.length;
        int C = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j, R, C));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j, int R, int C) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        grid[i][j] = 0;
        int area = 0;
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int x = top[0];
            int y = top[1];
            area++;
            if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                queue.add(new int[]{x, y - 1});
                grid[x][y - 1] = 0;
            }
            if (y + 1 < C && grid[x][y + 1] == 1) {
                queue.add(new int[]{x, y + 1});
                grid[x][y + 1] = 0;
            }
            if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                queue.add(new int[]{x - 1, y});
                grid[x - 1][y] = 0;
            }
            if (x + 1 < R && grid[x + 1][y] == 1) {
                queue.add(new int[]{x + 1, y});
                grid[x + 1][y] = 0;
            }
        }
        return area;
    }
}
