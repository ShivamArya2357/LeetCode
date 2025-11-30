package Practice.src.warmup;

import java.util.HashMap;
import java.util.Map;

public class LeetCode2537 {

    public static void main(String[] args) {

    }

    public long countGood(int[] nums, int k) {

        int n = nums.length;
        int l = 0;
        int ans = 0;
        int pairs = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int r = 0; r < n; r++) {
            int currNum = nums[r];
            pairs += freqMap.getOrDefault(currNum, 0);
            freqMap.put(currNum, freqMap.getOrDefault(currNum, 0) + 1);
            while (pairs >= k) {
                ans += (n - r);
                freqMap.put(nums[l], freqMap.get(nums[l]) - 1);
                pairs -= freqMap.get(nums[l]);
                l++;
            }
        }
        return ans;
    }
}
