package Practice.src.warmup;

import java.util.Arrays;

public class LeetCode2560 {

    public static void main(String[] args) {

    }

    public int minCapability(int[] nums, int k) {

        int l = Arrays.stream(nums).min().getAsInt();
        int h = Arrays.stream(nums).max().getAsInt();
        int ans = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (isPossible(nums, k, mid)) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] nums, int k, int mid) {

        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= mid) {
                i++;
                count++;
            }
        }
        return count >= k;
    }
}
