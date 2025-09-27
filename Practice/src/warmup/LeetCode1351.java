package Practice.src.warmup;

public class LeetCode1351 {

    public static void main(String[] args) {

    }

    public int countNegatives(int[][] grid) {

        int R = grid.length;
        int C = grid[0].length;
        int i = R - 1;
        int j = 0;
        int ans = 0;
        while (i >= 0 && j < C) {
            if (grid[i][j] < 0) {
                ans += (C - j);
                i--;
            } else {
                j++;
            }
        }
        return ans;
    }
}
