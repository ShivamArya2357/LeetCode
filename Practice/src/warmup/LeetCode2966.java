package Practice.src.warmup;

import java.util.Arrays;

public class LeetCode2966 {

    public static void main(String[] args) {

    }

    public int[][] divideArray(int[] nums, int k) {

        int n = nums.length;
        int rows = n / 3;
        int[][] res = new int[rows][3];
        Arrays.sort(nums);
        for (int i = 0, j = 0; i < n; i += 3) {
            int minEle = Math.min(nums[i], Math.min(nums[i + 1], nums[i + 2]));
            int maxEle = Math.max(nums[i], Math.max(nums[i + 1], nums[i + 2]));
            if (maxEle - minEle <= k) {
                res[j][0] = nums[i];
                res[j][1] = nums[i + 1];
                res[j][2] = nums[i + 2];
                j++;
            } else {
                return new int[][]{};
            }
        }
        return res;
    }
}
