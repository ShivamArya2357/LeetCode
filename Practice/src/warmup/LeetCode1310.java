package Practice.src.warmup;

public class LeetCode1310 {

    public static void main(String[] args) {

    }

    public int[] xorQueries(int[] arr, int[][] queries) {

        int n = arr.length;
        int[] prefixXor = new int[n];
        prefixXor[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixXor[i] = prefixXor[i - 1] ^ arr[i];
        }
        int totalQueries = queries.length;
        int[] ans = new int[totalQueries];
        for (int i = 0; i < totalQueries; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            if (l > 0) {
                ans[i] = prefixXor[r] - prefixXor[l - 1];
            } else {
                ans[i] = prefixXor[r];
            }
        }
        return ans;
    }
}
