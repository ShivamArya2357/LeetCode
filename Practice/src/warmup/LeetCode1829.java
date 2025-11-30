package Practice.src.warmup;

public class LeetCode1829 {

    public static void main(String[] args) {

    }

    public int[] getMaximumXor(int[] nums, int maximumBit) {

        int len = nums.length;
        int[] res = new int[len];
        for (int i = 1; i < len; i++) {
            nums[i] ^= nums[i - 1];
        }
        int mask = (1 << maximumBit) - 1;
        for (int i = len - 1; i >= 0; i--) {
            res[i] = nums[len - i - 1] ^ mask;
        }
        return res;
    }
}
