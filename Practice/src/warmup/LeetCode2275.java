package Practice.src.warmup;

public class LeetCode2275 {

    public static void main(String[] args) {

    }

    public int largestCombination(int[] candidates) {

        int ans = 0;
        for (int i = 0; i < 24; i++) {
            int onesCount = 0;
            for (int candidate : candidates) {
                if ((candidate & (1 << i)) != 0) {
                    onesCount++;
                }
            }
            ans = Math.max(ans, onesCount);
        }
        return ans;
    }
}
