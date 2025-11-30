package Practice.src.warmup;

public class LeetCode1749 {

    public static void main(String[] args) {

    }

    public int maxAbsoluteSum(int[] nums) {

        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int currentMaxSum = 0;
        int currentMinSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentMaxSum = Math.max(nums[i], currentMaxSum + nums[i]);
            currentMinSum = Math.min(nums[i], currentMinSum + nums[i]);
            maxSum = Math.max(maxSum, currentMaxSum);
            minSum = Math.max(minSum, currentMinSum);
        }
        return maxSum > Math.abs(minSum) ? maxSum : Math.abs(minSum);
    }
}
