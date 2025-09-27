package Practice.src.warmup;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1 {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {

        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                return new int[] {map.get(target - nums[i]), i};
            }
        }
        return null;
    }
}
