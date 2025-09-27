package Practice.src.warmup;

public class LeetCode1020 {

    public static void main(String[] args) {

    }

    public int numEnclaves(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && (i == 0 || i == row - 1 || j == 0 || j == col - 1)) {
                    grid[i][j] = 0;
                    dfs(grid, row, col, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] grid, int row, int col, int i, int j) {

        if (i < 0 || i >= row || j < 0 || j >= col) {
            return;
        }
        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
            grid[i][j - 1] = 0;
            dfs(grid, row, col, i, j - 1);
        }
        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            grid[i - 1][j] = 0;
            dfs(grid, row, col, i - 1, j);
        }
        if (i + 1 < row && grid[i + 1][j] == 1) {
            grid[i + 1][j] = 0;
            dfs(grid, row, col, i + 1, j);
        }
        if (j + 1 < col && grid[i][j + 1] == 1) {
            grid[i][j + 1] = 0;
            dfs(grid, row, col, i, j + 1);
        }
    }
}
