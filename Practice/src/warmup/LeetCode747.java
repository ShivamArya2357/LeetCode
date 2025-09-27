package Practice.src.warmup;

import java.util.Arrays;

public class LeetCode747 {

    public static void main(String[] args) {

    }

    public int dominantIndex(int[] nums) {

        int n = nums.length;
        int maxElement = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxElement = Math.max(maxElement, nums[i]);
        }
        for (int i = 0; i < n; i++) {
            if (2 * nums[i] < maxElement) {
                return -1;
            }
        }
        return 1;
    }
}
