package Practice.src.warmup;

public class LeetCode1283 {

    public static void main(String[] args) {

        LeetCode1283 test = new LeetCode1283();
        int[] nums = {44,22,33,11,1};
        int threshold = 5;
        int ans = test.smallestDivisor(nums, threshold);
        System.out.println(ans);
    }

    public int smallestDivisor(int[] nums, int threshold) {

        int l = 1;
        int h = 1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            h = Math.max(h, nums[i]);
        }
        int ans = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int value = getValue(nums, n, mid);
            if (value <= threshold) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private int getValue(int[] nums, int n, int mid) {

        int value = 0;
        for (int i = 0; i < n; i++) {
            value += (int) Math.ceil(nums[i] / (double) (mid));
        }
        return value;
    }
}
