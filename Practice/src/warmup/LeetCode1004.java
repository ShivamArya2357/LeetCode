package Practice.src.warmup;

public class LeetCode1004 {

    public static void main(String[] args) {

        LeetCode1004 test = new LeetCode1004();
        int[] nums = {0,0,0,0,0,0};
        int k = 6;
        int ans = test.longestOnes(nums, k);
        System.out.println(ans);
    }

//    public int longestOnes(int[] nums, int k) {
//
//        int n = nums.length;
//        int start = 0;
//        int count = 0;
//        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            if (nums[i] == 0) {
//                count++;
//            }
//            if (count > k) {
//                while (start < n && nums[start] == 1) {
//                    start++;
//                }
//                if (start < n && nums[start] == 0) {
//                    start++;
//                    count--;
//                }
//            }
//            ans = Math.max(ans, i - start + 1);
//        }
//        return ans;
//    }

    public int longestOnes(int[] nums, int k) {

        int left = 0;
        int zeros = 0;
        int ans = 0;
        int n = nums.length;
        for (int right = 0; right < n; right++) {
            if (nums[right] == 0) {
                zeros++;
            }
            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
