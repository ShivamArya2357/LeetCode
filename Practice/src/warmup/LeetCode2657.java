package Practice.src.warmup;

public class LeetCode2657 {

    public static void main(String[] args) {

    }

    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        int len = A.length;
        int[] hash1 = new int[51];
        int[] hash2 = new int[51];
        int ans = 0;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            hash1[A[i]]++;
            hash2[B[i]]++;
            if (A[i] != B[i]) {
                if (hash1[B[i]] != 0) {
                    ans++;
                }
                if (hash2[A[i]] != 0) {
                    ans++;
                }
            } else {
                ans++;
            }
            res[i] = ans;
        }
        return res;
    }
}
