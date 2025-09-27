package Practice.src.warmup;

import java.util.Arrays;

public class LeetCode73 {

    public static void main(String[] args) {

        LeetCode73 test = new LeetCode73();
        int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        test.setZeroes(matrix);
    }

//    public void setZeroes(int[][] matrix) {
//
//        int row = matrix.length;
//        int col = matrix[0].length;
//        int[] markRowZeroIndex = new int[row];
//        int[] markColZeroIndex = new int[col];
//        Arrays.fill(markRowZeroIndex, -1);
//        Arrays.fill(markColZeroIndex, -1);
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (matrix[i][j] == 0) {
//                    if (markRowZeroIndex[i] == -1) {
//                        markRowZeroIndex[i] = i;
//                    }
//                    if (markColZeroIndex[j] == -1) {
//                        markColZeroIndex[j] = j;
//                    }
//                }
//            }
//        }
//        for (int i = 0; i < row; i++) {
//            if (markRowZeroIndex[i] != -1) {
//                int currRow = markRowZeroIndex[i];
//                for (int j = 0; j < col; j++) {
//                    matrix[currRow][j] = 0;
//                }
//            }
//        }
//        for (int i = 0; i < col; i++) {
//            if (markColZeroIndex[i] != -1) {
//                int currCol = markColZeroIndex[i];
//                for (int j = 0; j < row; j++) {
//                    matrix[j][currCol] = 0;
//                }
//            }
//        }
//    }

    public void setZeroes(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        boolean firstRowShouldBeZero = false;
        boolean firstColShouldBeZero = false;
        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == 0) {
                firstRowShouldBeZero = true;
                break;
            }
        }

        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                firstColShouldBeZero = true;
                break;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstRowShouldBeZero) {
            for (int i = 0; i < col; i++) {
                matrix[0][i] = 0;
            }
        }
        if (firstColShouldBeZero) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
