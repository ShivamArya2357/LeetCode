package Practice.src.warmup;

import java.util.Arrays;

public class LeetCode1043 {

    public static void main(String[] args) {

    }

    public int maxSumAfterPartitioning(int[] arr, int k) {

        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        int l = 0;
        int ans = solve(arr, l, k, dp);
        return ans;
    }

    private int solve(int[] arr, int l, int k, int[] dp) {

        int ans = 0;
        int maxValue = 0;
        if (l >= arr.length) {
            return 0;
        } else if (dp[l] != -1) {
            return dp[l];
        } else {
            int h = Math.min(arr.length, l + k - 1);
            for (int i = l; i <= h; i++) {
                maxValue = Math.max(maxValue, arr[i]);
                ans = Math.max(ans, maxValue * (i - l + 1) + solve(arr, i + 1, k, dp));
            }
            dp[l] = ans;
            return ans;
        }
    }
}
