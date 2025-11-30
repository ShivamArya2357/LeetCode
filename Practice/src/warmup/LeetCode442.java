package Practice.src.warmup;

import java.util.ArrayList;
import java.util.List;

public class LeetCode442 {

    public static void main(String[] args) {

        LeetCode442 test = new LeetCode442();
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        test.findDuplicates(nums);
    }

    public List<Integer> findDuplicates(int[] nums) {

        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int nextIndex = Math.abs(nums[i]) - 1;
            if (nums[nextIndex] < 0) {
                ans.add(Math.abs(nums[i]));
            } else {
                nums[nextIndex] = -nums[nextIndex];
            }
        }
        return ans;
    }
}
