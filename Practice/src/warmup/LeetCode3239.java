package Practice.src.warmup;

public class LeetCode3239 {

    public static void main(String[] args) {

    }

    public int minFlips(int[][] grid) {

        int R = grid.length;
        int C = grid[0].length;
        int rowMisMatches = 0;
        int colMisMatches = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C / 2; j++) {
                if (grid[i][j] != grid[i][C - j - 1]) {
                    rowMisMatches++;
                }
            }
        }
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R / 2; j++) {
                if (grid[j][i] != grid[R - j - 1][i]) {
                    colMisMatches++;
                }
            }
        }
        return Math.min(rowMisMatches, colMisMatches);
    }
}
