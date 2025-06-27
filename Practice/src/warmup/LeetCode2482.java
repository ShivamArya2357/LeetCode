package Practice.src.warmup;

public class LeetCode2482 {

    public static void main(String[] args) {

    }

    public int[][] onesMinusZeros(int[][] grid) {

        int rowCount = grid.length;
        int colCount = grid[0].length;
        int[] oneRow = new int[rowCount];
        int[] oneCol = new int[colCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == 1) {
                    oneRow[i]++;
                    oneCol[j]++;
                }
            }
        }
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                grid[i][j] = 2 * (oneRow[i] + oneCol[j]) - (rowCount + colCount);
            }
        }
        return grid;
    }
}
