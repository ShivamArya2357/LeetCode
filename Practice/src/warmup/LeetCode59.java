package Practice.src.warmup;

public class LeetCode59 {

    private static int count = 1;

    private static int[][] directions = new int[][]{{0, 1},{1,0},{0,-1},{-1,0}};

    public static void main(String[] args) {

        int n = 1;
        int[][] res = generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

//    public static int[][] generateMatrix(int n) {
//
//        int[][] res = new int[n][n];
//        for (int i = 0; i < n / 2; i++) {
//            int lastCol = n - i - 1;
//            int lastRow = n - i - 1;
//            fillMatrix(i, lastCol, lastRow, res);
//        }
//        if (n % 2 == 1) {
//            res[n / 2][n / 2] = n * n;
//        }
//        return res;
//    }
//
//    private static void fillMatrix(int startRow, int lastCol, int lastRow, int[][] res) {
//
//        int startCol = startRow;
//        for (int i = startCol; i <= lastCol; i++) {
//            res[startRow][i] = count++;
//        }
//        for (int i = startRow + 1; i < lastRow; i++) {
//            res[i][lastCol] = count++;
//        }
//        for (int i = lastCol; i >= startCol; i--) {
//            res[lastRow][i] = count++;
//        }
//        for (int i = lastRow - 1; i > startRow; i--) {
//            res[i][startCol] = count++;
//        }
//    }

    public static int[][] generateMatrix(int n) {

        int[][] res = new int[n][n];
        int row = 0;
        int col = 0;
        int index = 0;
        while (count <= n * n) {
            res[row][col] = count++;
            int nextRow = Math.floorMod(row + directions[index][0], n);
            int nextCol = Math.floorMod(col + directions[index][1], n);
            if (res[nextRow][nextCol] != 0) {
                index = (index + 1) % n;
            }
            row += directions[index][0];
            col += directions[index][1];
        }
        return res;
    }
}
