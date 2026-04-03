package Practice.src.warmup;

public class MinimumSwaps {

    public static void main(String[] args) {

        MinimumSwaps test = new MinimumSwaps();
        int[] A = {5, 17, 100, 11};
        int B = 20;
        int ans = test.solve(A, B);
        System.out.println(ans);
    }

    public int solve(int[] A, int B) {

        int n = A.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] <= B) {
                total++;
            }
        }
        int count = 0;
        for (int i = 0; i < total; i++) {
            if (A[i] <= B) {
                count++;
            }
        }
        int i = 1;
        int j = total;
        int ans = total - count;
        while (j < n) {
            if (A[i - 1] <= B) {
                count--;
            }
            if (A[j] <= B) {
                count++;
            }
            ans = Math.min(ans, total - count);
            i++;
            j++;
        }
        return ans;
    }
}
