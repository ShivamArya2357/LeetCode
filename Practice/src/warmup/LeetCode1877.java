package Practice.src.warmup;

import java.util.Arrays;
import java.util.Map;

public class LeetCode1877 {

    public static void main(String[] args) {

        LeetCode1877 test = new LeetCode1877();
        int[] nums = {3,5,4,2,4,6};
        int ans = test.minPairSum(nums);
        System.out.println(ans);
    }

    public int minPairSum(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i <= n / 2; i++) {
            ans = Math.max(ans, nums[i] + nums[n - i - 1]);
        }
        return ans;
    }
}
