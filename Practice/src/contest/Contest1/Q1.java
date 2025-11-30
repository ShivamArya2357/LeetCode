package Practice.src.contest.Contest1;

public class Q1 {

    public static void main(String[] args) {


    }

    public int maxAdjacentDistance(int[] nums) {

        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int currentEle = nums[i];
            int nextEle = nums[(i + 1) % n];
            ans = Math.max(ans, Math.abs(nextEle - currentEle));
        }
        return ans;
    }
}
