package Practice.src.warmup;

public class LeetCode2656 {

    public static void main(String[] args) {

    }

    public int maximizeSum(int[] nums, int k) {

        int n = nums.length;
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxNum = Math.max(maxNum, nums[i]);
        }
        return maxNum * k + (k * (k - 1)) / 2;
    }
}
