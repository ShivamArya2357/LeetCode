package Practice.src.warmup;

import java.util.Arrays;

public class PickFromBothTheSides {

    public static void main(String[] args) {

        PickFromBothTheSides test = new PickFromBothTheSides();
        int[] A = {2, 3, -1, 4, 2, 1};
        int B = 4;
        int ans = test.solve(A, B);
        System.out.println(ans);
    }

    public int solve(int[] A, int B) {

        int n = A.length;
        if (B < n) {
            int[] prefixSum = new int[n];
            prefixSum[0] = A[0];
            for (int i = 1; i < n; i++) {
                prefixSum[i] = prefixSum[i - 1] + A[i];
            }
            int ans = prefixSum[n - 1] - prefixSum[n - B - 1];
            for (int i = 0; i < B; i++) {
                ans = Math.max(ans,
                        prefixSum[i] + prefixSum[n - 1] - prefixSum[n - B + i]
                );
            }
            return ans;
        } else {
            return Arrays.stream(A).sum();
        }
    }
}
