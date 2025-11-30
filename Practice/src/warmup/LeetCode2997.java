package Practice.src.warmup;

public class LeetCode2997 {

    public static void main(String[] args) {

    }

    public int minOperations(int[] nums, int k) {

        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < 20; i++) {
            int oneCount = 0;
            for (int j = 0; j < len; j++) {
                if ((nums[j] & (1 << i)) != 0) {
                    oneCount++;
                }
            }
            if ((k & (1 << i)) != 0) {
                if (oneCount % 2 == 0) {
                    ans++;
                }
            } else {
                if (oneCount % 2 == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
