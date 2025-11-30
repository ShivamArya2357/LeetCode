package Practice.src.warmup;

public class LeetCode260 {

    public static void main(String[] args) {

    }

    public int[] singleNumber(int[] nums) {

        int n = nums.length;
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
        }
        int mask = xor & -xor;
        int a = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            if ((nums[i] & mask) != 0) {
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }
        return new int[]{a, b};
    }
}
