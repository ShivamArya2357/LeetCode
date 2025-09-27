package Practice.src.warmup;

import java.util.Arrays;

public class LeetCode2134 {

    public static void main(String[] args) {

        LeetCode2134 test = new LeetCode2134();
        int[] nums = {1,1,0,0,1};
        int ans = test.minSwaps(nums);
        System.out.println(ans);
    }

    public int minSwaps(int[] nums) {

        int n = nums.length;
        int totalOnes = Arrays.stream(nums).filter(num -> num == 1).sum();
        if (totalOnes == 0) {
            return 0;
        }
        int l = 0;
        int r = 0;
        int swapCount = Integer.MAX_VALUE;
        int countZeroes = 0;
        int countOnes = 0;
        while (l < n) {
            if (nums[r] == 0) {
                countZeroes++;
            } else {
                countOnes++;
            }
            if (countZeroes + countOnes == totalOnes) {
                swapCount = Math.min(swapCount, countZeroes);
                if (nums[l] == 0) {
                    countZeroes--;
                } else {
                    countOnes--;
                }
                l++;
            }
            r = (r + 1) % n;
        }
        return swapCount;
    }
}
