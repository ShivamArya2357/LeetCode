package Practice.src.warmup;

public class LeetCode2149 {

    public static void main(String[] args) {

        LeetCode2149 test = new LeetCode2149();
        int[] nums = {3,1,2,-2,-5,-4, 2};
        int[] ans = test.rearrangeArray(nums);
        for (int ele : ans) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public int[] rearrangeArray(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                ans[count] = nums[i];
                count += 2;
            }
        }
        count = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                ans[count] = nums[i];
                count += 2;
            }
        }
        return ans;
    }
}
