package Practice.src.warmup;

public class EvenNumbersInRange {

    public static void main(String[] args) {

    }

    public int[] solve(int[] A, int[][] B) {

        int n = A.length;
        int[] prefixSum = new int[n];
        for (int i = 0; i < n; i++) {
            if (A[i] % 2 == 0) {
                if (i == 0) {
                    prefixSum[i] = 1;
                } else {
                    prefixSum[i] = prefixSum[i - 1] + 1;
                }
            } else {
                if (i > 0) {
                    prefixSum[i] = prefixSum[i - 1];
                }
            }
        }
        int q = B.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int l = B[i][0];
            int r = B[i][1];
            if (l == 0) {
                ans[i] = prefixSum[r];
            } else {
                ans[i] = prefixSum[r] - prefixSum[l - 1];
            }
        }
        return ans;
    }
}
