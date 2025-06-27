package Practice.src.warmup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode1442 {

    public static void main(String[] args) {

        int[] arr = new int[]{1,1,1,1,1};
        LeetCode1442 test = new LeetCode1442();
        int ans = test.countTriplets(arr);
        System.out.println(ans);
    }

    public int countTriplets(int[] arr) {

        int len = arr.length;
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = arr[i];
            for (int k = i + 1; k < len; k++) {
                dp[i][k] = arr[k] ^ dp[i][k - 1];
            }
        }
        int ans = 0;
        for (int j = 1; j < len; j++) {
            int j1 = j - 1;
            List<Integer> res1 = new ArrayList<>();
            for (int i = 0; i <= j1; i++) {
                res1.add(dp[i][j1]);
            }
            List<Integer> res2 = new ArrayList<>();
            int j2 = j;
            for (int i = j2; i < len; i++) {
                res2.add(dp[j2][i]);
            }
            for (int i = 0; i < res1.size(); i++) {
                for (int j3 = 0; j3 < res2.size(); j3++) {
                    if (res1.get(i).equals(res2.get(j3))) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
