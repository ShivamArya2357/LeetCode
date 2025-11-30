package Practice.src.warmup;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode959 {

    private static final int[][] DIRECTIONS = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public static void main(String[] args) {

    }

    public int regionsBySlashes(String[] grid) {

        int gridSize = grid.length;
        int newGridSize = 3 * gridSize;
        int[][] newGrid = new int[newGridSize][newGridSize];
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                int baseRow = 3 * i;
                int baseCol = 3 * j;
                if (grid[i].charAt(j) == '\\') {
                    newGrid[baseRow][baseCol] = 1;
                    newGrid[baseRow + 1][baseCol + 1] = 1;
                    newGrid[baseRow + 2][baseCol + 2] = 1;
                } else if (grid[i].charAt(j) == '/') {
                    newGrid[baseRow][baseCol + 2] = 1;
                    newGrid[baseRow + 1][baseCol + 1] = 1;
                    newGrid[baseRow + 2][baseCol] = 1;
                }
            }
        }
        int regionCount = 0;
        for (int i = 0; i < newGridSize; i++) {
            for (int j = 0; j < newGridSize; j++) {
                if (newGrid[i][j] == 0) {
                    floodFill(newGrid, i, j);
                    regionCount++;
                }
            }
        }
        return regionCount;
    }

    private void floodFill(int[][] newGrid, int row, int col) {

        Queue<int[]> queue = new LinkedList<>();
        newGrid[row][col] = 1;
        queue.add(new int[]{row, col});
        while (!queue.isEmpty()) {
            int[] currentCell = queue.poll();
            for (int[] direction : DIRECTIONS) {
                int newRow = currentCell[0] + direction[0];
                int newCol = currentCell[1] + direction[1];
                if (isValidCell(newGrid, newRow, newCol)) {
                    newGrid[newRow][newCol] = 1;
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }
    }

    private boolean isValidCell(int[][] newGrid, int newRow, int newCol) {

        int n = newGrid.length;
        return newRow >= 0 && newCol >= 0 && newRow < n && newCol < n && newGrid[newRow][newCol] == 0;
    }
}
