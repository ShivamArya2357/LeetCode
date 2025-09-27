package Practice.src.warmup;

public class LeetCode2980 {

    public static void main(String[] args) {

    }

    public boolean hasTrailingZeros(int[] nums) {

        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int currNum = nums[i];
            if ((currNum & 1) == 0) {
                count++;
            }
        }
        return count >= 2;
    }
}
