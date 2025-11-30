package Practice.src.warmup;

public class LeetCode1760 {

    public static void main(String[] args) {

    }

    public int minimumSize(int[] nums, int maxOperations) {

        int l = 1;
        int h = 1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            h = Math.max(h, nums[i]);
        }
        int ans = 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (isPossible(nums, maxOperations, mid)) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] nums, int maxOperations, int maxBalls) {

        int totalOperations = 0;
        for (int i = 0; i < nums.length; i++) {
            totalOperations += (int) (Math.ceil((double) nums[i] / maxBalls) - 1);
            if (totalOperations > maxOperations) {
                return false;
            }
        }
        return true;
    }
}
