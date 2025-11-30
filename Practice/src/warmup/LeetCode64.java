package Practice.src.warmup;

public class LeetCode64 {

    public static void main(String[] args) {

        int[][] grid = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int ans = minPathSum(grid);
        System.out.println(ans);
    }

    public static int minPathSum(int[][] grid) {

        int totalRow = grid.length;
        int totalCol = grid[0].length;
        int[][] dp = new int[totalRow][totalCol];
        for (int i = 0; i < totalRow; i++) {
            for (int j = 0; j < totalCol; j++) {
                dp[i][j] = -1;
            }
        }
        return findMinPathSum(grid, totalRow, totalCol, 0, 0, dp);
    }

    private static int findMinPathSum(
            int[][] grid, int totalRow, int totalCol, int currentRow, int currentCol, int[][] dp
    ) {

        if (currentRow == totalRow - 1 && currentCol == totalCol - 1) {
            return grid[currentRow][currentCol];
        }
        if (isCurrentRowAndCurrentColumnOutOfMatrix(currentRow, currentCol, totalRow, totalCol)) {
            return Integer.MAX_VALUE;
        }
        if (dp[currentRow][currentCol] != -1) {
            return dp[currentRow][currentCol];
        }
        return (dp[currentRow][currentCol] = grid[currentRow][currentCol] + Math.min(
                findMinPathSum(grid, totalRow, totalCol, currentRow, currentCol + 1, dp),
                findMinPathSum(grid, totalRow, totalCol, currentRow + 1, currentCol, dp)
        ));
    }

    private static boolean isCurrentRowAndCurrentColumnOutOfMatrix(int currentRow, int currentCol, int totalRow, int totalCol) {
        return (currentRow >= totalRow || currentCol >= totalCol);
    }
}
