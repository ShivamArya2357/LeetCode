package Practice.src.warmup;

public class LeetCode413 {

    public static void main(String[] args) {

        LeetCode413 test = new LeetCode413();
        int[] nums = {1, 3, 5, 7, 9, 11, 17, 23, 30};
        int ans = test.numberOfArithmeticSlices(nums);
        System.out.println(ans);
    }

    public int numberOfArithmeticSlices(int[] nums) {

        int n = nums.length;
        if (n < 3) {
            return 0;
        }
        int l = 0;
        int d = nums[1] - nums[0];
        int ans = 0;
        int count = 1;
        int r = 0;
        for (r = 2; r < n; r++) {
            if (nums[r] - nums[r - 1] == d) {
                count++;
            } else {
                while (count >= 2) {
                    ans += (r - l - 2);
                    count--;
                    l++;
                }
                d = nums[r] - nums[r - 1];
                l = r - 1;
            }
        }
        while (count >= 2) {
            ans += (r - l - 2);
            count--;
            l++;
        }
        return ans;
    }
}
