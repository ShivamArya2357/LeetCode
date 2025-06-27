package Practice.src.warmup;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1992 {

    public static void main(String[] args) {

        int[][] land = new int[][]{{0}};
        int[][] ans = findFarmland(land);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0] + " " + ans[i][1] + " " + ans[i][2] + " " + ans[i][3]);
        }
    }

    public static int[][] findFarmland(int[][] land) {

        int rowCount = land.length;
        int colCount = land[0].length;
        List<int[][]> tempAns = new ArrayList<>();
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (land[i][j] == 1) {
                    int startRow = i;
                    int startCol = j;
                    int k = i + 1;
                    for (k = i + 1; k < rowCount; k++) {
                        if (land[k][j] == 0) {
                            break;
                        }
                    }
                    int endRow = k - 1;
                    k = j + 1;
                    for (k = j + 1; k < colCount; k++) {
                        if (land[i][k] == 0) {
                            break;
                        }
                    }
                    int endCol = k - 1;
                    reset(land, startRow, startCol, endRow, endCol);
                    tempAns.add(new int[][]{{startRow, startCol}, {endRow, endCol}});
                }
            }
        }
        int[][] ans = new int[tempAns.size()][4];
        int index = 0;
        for (int[][] coOrdinates : tempAns) {
            int[] start = coOrdinates[0];
            int[] end = coOrdinates[1];
            ans[index][0] = start[0];
            ans[index][1] = start[1];
            ans[index][2] = end[0];
            ans[index][3] = end[1];
            index++;
        }
        return ans;
    }

    private static void reset(int[][] land, int startRow, int startCol, int endRow, int endCol) {

        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                land[i][j] = 0;
            }
        }
    }
}
