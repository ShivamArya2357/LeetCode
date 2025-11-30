package Practice.src.warmup;

import java.util.ArrayList;
import java.util.List;

public class LeetCode89 {

    // Problem Link - https://leetcode.com/problems/gray-code/description/

    public static void main(String[] args) {

        List<Integer> grayCodes = grayCode(5);
        for (Integer grayCode : grayCodes) {
            System.out.println(grayCode);
        }
    }

    public static List<Integer> grayCode(int n) {

        List<Integer> grayCodes = new ArrayList<>();
        grayCodes.add(0);
        int k = (1 << n);
        int size = (1 << k);
        int[] dp = new int[size];
        for (int i = 0; i < size; i++) {
            dp[i] = -1;
        }
        findGrayCode(k, 0, 1, dp, grayCodes);
        return grayCodes;
    }

    private static boolean findGrayCode(int k, int prevNum, int mask, int[] dp, List<Integer> grayCodes) {

        if ((mask == ((1 << k) - 1))) {
            if (((prevNum) & (prevNum - 1)) != 0) {
                dp[mask] = 0;
                return false;
            } else {
                dp[mask] = 1;
                return true;
            }
        }
        if (dp[mask] != -1) {
            return dp[mask] != 0;
        }
        for (int i = 1; i < k; i++) {
            if ((mask & (1 << i)) == 0) {
                if (hasSingleBitDifference(prevNum, i)) {
                    grayCodes.add(i);
                    if (findGrayCode(k, i, mask | (1 << i), dp, grayCodes)) {
                        dp[mask] = 1;
                        return true;
                    } else {
                        mask = mask & (~(1 << i));
                        grayCodes.removeLast();
                    }
                }
            }
        }
        return false;
    }

    public static boolean hasSingleBitDifference(int prevNum, int i) {
        int xor = prevNum ^ i; // XOR of the two numbers
        return xor > 0 && (xor & (xor - 1)) == 0; // Check if XOR is a power of 2
    }
}
