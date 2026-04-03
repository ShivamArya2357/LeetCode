package Practice.src.warmup;

public class ClosestMinMax {

    public static void main(String[] args) {

    }

    public int solve(int[] A) {

        int n = A.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (A[i] == min) {
                for (int j = i; j < n; j++) {
                    if (A[j] == max) {
                        ans = Math.min(ans, j - i + 1);
                        break;
                    }
                }
            }
            if (A[i] == max) {
                for (int j = i; j < n; j++) {
                    if (A[j] == min) {
                        ans = Math.min(ans, j - i + 1);
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
