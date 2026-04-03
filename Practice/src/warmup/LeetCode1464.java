package Practice.src.warmup;

public class LeetCode1464 {

    public static void main(String[] args) {

    }

    public int maxProduct(int[] nums) {

        int n = nums.length;
        int firstMax = 0;
        int firstMaxIndex = -1;
        int secondMax = 0;
        for (int i = 0; i < n; i++) {
            if (firstMax < nums[i]) {
                firstMax = nums[i];
                firstMaxIndex = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i != firstMaxIndex && secondMax < nums[i]) {
                secondMax = nums[i];
            }
        }
        return (firstMax - 1) * (secondMax - 1);
    }

    public int maxProduct2(int[] nums) {

        int n = nums.length;
        int firstMax = 0;
        int secondMax = 0;
        for (int i = 0; i < n; i++) {
            if (firstMax < nums[i]) {
                secondMax = firstMax;
                firstMax = nums[i];
            } else if (secondMax < nums[i]) {
                secondMax = nums[i];
            }
        }
        return (firstMax - 1) * (secondMax - 1);
    }
}
