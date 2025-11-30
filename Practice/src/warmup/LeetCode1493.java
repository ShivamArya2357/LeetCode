package Practice.src.warmup;

public class LeetCode1493 {

    public static void main(String[] args) {

        LeetCode1493 test = new LeetCode1493();
        int[] nums = {1,1,1};
        int ans = test.longestSubarray(nums);
        System.out.println(ans);
    }

    public int longestSubarray(int[] nums) {

        int n = nums.length;
        int LOneCounts = 0;
        int i = 0;
        int ans = 0;
        while (i < n) {
            if (nums[i] == 0) {
                int ROneCounts = 0;
                i++;
                while (i < n && nums[i] == 1) {
                    ROneCounts++;
                    i++;
                }
                ans = Math.max(ans, LOneCounts + ROneCounts);
                LOneCounts = ROneCounts;
            } else {
                ans = Math.max(ans, LOneCounts);
                LOneCounts++;
                i++;
            }
        }
        return ans;
    }
}
