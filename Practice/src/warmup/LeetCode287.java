package Practice.src.warmup;

public class LeetCode287 {

    public static void main(String[] args) {

        LeetCode287 test = new LeetCode287();
        int[] nums = {1,3,4,2,2};
        int ans = test.findDuplicate(nums);
        System.out.println(ans);
    }

    public int findDuplicate(int[] nums) {

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                return nums[i];
            }
            nums[index] = -nums[index];
        }
        return -1;
    }
}
