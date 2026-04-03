package Practice.src.warmup;

public class SpecialIndex {

    public static void main(String[] args) {

        SpecialIndex test = new SpecialIndex();
        int[] A = {2, 1, 6, 4};
        int ans = test.solve(A);
        System.out.println(ans);
    }

    public int solve(int[] A) {

        int n = A.length;
        int[] prefixOddSum = new int[n];
        int[] prefixEvenSum = new int[n];
        prefixEvenSum[0] = A[0];
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                prefixEvenSum[i] = prefixEvenSum[i - 1] + A[i];
            } else {
                prefixEvenSum[i] = prefixEvenSum[i - 1];
            }
        }
        for (int i = 1; i < n; i++) {
            if (i % 2 == 1) {
                prefixOddSum[i] = prefixOddSum[i - 1] + A[i];
            } else {
                prefixOddSum[i] = prefixOddSum[i - 1];
            }
        }
        int ans = 0;
        int oddSum = 0;
        int evenSum = 0;
        for (int i = 0; i < n; i++) {
            if (oddSum + prefixEvenSum[n - 1] - prefixEvenSum[i] == evenSum + prefixOddSum[n - 1] - prefixOddSum[i]) {
                ans++;
            }
            if (i % 2 == 0) {
                evenSum += A[i];
            } else {
                oddSum += A[i];
            }
        }
        return ans;
    }
}
