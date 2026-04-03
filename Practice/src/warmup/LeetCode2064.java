package Practice.src.warmup;

import java.util.Arrays;

public class LeetCode2064 {

    public static void main(String[] args) {

    }

    public int minimizedMaximum(int n, int[] quantities) {

        int l = 1;
        int h = Arrays.stream(quantities).max().getAsInt();
        int ans = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (isPossible(quantities, n, mid)) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] quantities, int n, int mid) {

        int count = 0;
        for (int i = 0; i < quantities.length; i++) {
            count += (quantities[i] + mid - 1) / mid;
        }
        return count <= n;
    }
}
