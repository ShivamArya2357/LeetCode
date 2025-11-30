package Practice.src.warmup;

public class LeetCode3151 {

    public static void main(String[] args) {

    }

    public boolean isArraySpecial(int[] nums) {

        int n = nums.length;
        boolean prevElementEven = false;
        if (nums[0] % 2 == 0) {
            prevElementEven = true;
        }
        for (int i = 1; i < n; i++) {
            if (prevElementEven) {
                if (nums[i] % 2 == 0) {
                    return false;
                }
                prevElementEven = false;
            } else {
                if (nums[i] % 2 != 0) {
                    return false;
                }
                prevElementEven = true;
            }
        }
        return true;
    }
}
