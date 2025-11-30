package Practice.src.warmup;

import java.util.Map;

public class LeetCode1277 {

    public static void main(String[] args) {

    }

    public int countSquares(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < col; i++) {
            dp[0][i] = matrix[i][0];
        }
        for (int i = 1; i < row; i++) {
            dp[i][0] = matrix[i][0];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans += dp[i][j];
            }
        }
        return ans;
    }
}
