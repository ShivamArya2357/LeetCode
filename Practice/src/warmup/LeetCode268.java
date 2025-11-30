package Practice.src.warmup;

public class LeetCode268 {

    public int missingNumber(int[] nums) {

        int n = nums.length;
        int expectedSum = (n * (n + 1)) / 2;
        int foundSum = 0;
        for (int i = 0; i < n; i++) {
            foundSum += nums[i];
        }
        return expectedSum - foundSum;
    }
}
