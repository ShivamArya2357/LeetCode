package Practice.src.warmup;

import java.util.Arrays;

public class LeetCode2679 {

    public static void main(String[] args) {

    }

    public int matrixSum(int[][] nums) {

        int rowLen = nums.length;
        int colLen = nums[0].length;
        for (int row = 0; row < rowLen; row++) {
            int[] rowElements = new int[colLen];
            for (int col = 0; col < colLen; col++) {
                rowElements[col] = nums[row][col];
            }
            Arrays.sort(rowElements);
            for (int col = 0; col < colLen; col++) {
                nums[row][col] = rowElements[col];
            }
        }
        int res = 0;
        for (int col = 0; col < colLen; col++) {
            int maxEle = Integer.MIN_VALUE;
            for (int row = 0; row < rowLen; row++) {
                maxEle = Math.max(maxEle, nums[row][col]);
            }
            if (maxEle != Integer.MIN_VALUE) {
                res += maxEle;
            }
        }
        return res;
    }
}
