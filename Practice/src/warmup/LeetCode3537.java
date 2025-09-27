package Practice.src.warmup;

public class LeetCode3537 {

    public static void main(String[] args) {

        LeetCode3537 test = new LeetCode3537();
        int[][] grid = test.specialGrid(1);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] specialGrid(int n) {

        int gridSize = (1 << n);
        int[][] grid = new int[gridSize][gridSize];
        int[] count = {0};
        fill(grid, 0, 0, gridSize, count);
        return grid;
    }

    private void fill(int[][] grid, int r, int c, int gridSize, int[] count) {

        if (gridSize == 1) {
            grid[r][c] = count[0]++;
            return;
        }
        gridSize /= 2;
        fill(grid, r, c + gridSize, gridSize, count);
        fill(grid, r + gridSize, c + gridSize, gridSize, count);
        fill(grid, r + gridSize, c, gridSize, count);
        fill(grid, r, c, gridSize, count);
    }
}
