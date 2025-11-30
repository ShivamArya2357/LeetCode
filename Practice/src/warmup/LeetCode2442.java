package Practice.src.warmup;

import java.util.HashSet;
import java.util.Set;

public class LeetCode2442 {

    public static void main(String[] args) {

        int[] nums = new int[]{1,13,10,12,31};
        int distinctCount = countDistinctIntegers(nums);
    }

    public static int countDistinctIntegers(int[] nums) {

        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            set.add(num);
            int reverseNum = 0;
            while (num > 0) {
                reverseNum = reverseNum * 10 + num % 10;
                num /= 10;
            }
            set.add(reverseNum);
        }
        return set.size();
    }
}
