package Practice.src.warmup;

import java.util.Arrays;

public class MinimumTime {

    public static void main(String[] args) {

    }

    public int solve(int[] A) {

        int maxEle = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            maxEle = Math.max(maxEle, A[i]);
        }
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            ans += maxEle - A[i];
        }
        return ans;
    }
}
