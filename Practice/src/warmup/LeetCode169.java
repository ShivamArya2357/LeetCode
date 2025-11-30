package Practice.src.warmup;

public class LeetCode169 {

    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {

        int count = 0;
        int candidate = Integer.MIN_VALUE;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else {
                count += (candidate == num) ? 1 : -1;
            }
        }
        return candidate;
    }
}
