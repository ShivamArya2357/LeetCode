package Practice.src.warmup;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode91 {

    public static void main(String[] args) {

        Set<String> validCodes = new HashSet<>();
        for (int i = 1; i <= 26; i++) {
            validCodes.add(String.valueOf(i));
        }
        LeetCode91 test = new LeetCode91();
        Map<Integer, Integer> dp = new HashMap<>();
        test.numDecodings("", 0, validCodes, dp);
    }

    private int numDecodings(
            String s, int currIndex, Set<String> validCodes, Map<Integer, Integer> dp
    ) {

        if (currIndex == s.length()) {
            return 1;
        } else if (dp.containsKey(currIndex)) {
            return dp.get(currIndex);
        } else {
            int ans = 0;
            if (isValidCode(s.substring(currIndex, currIndex + 1), validCodes)) {
                ans += numDecodings(s, currIndex + 1, validCodes, dp);
            }
            if (currIndex + 1 < s.length() && isValidCode(s.substring(currIndex, currIndex + 2), validCodes)) {
                ans += numDecodings(s, currIndex + 2, validCodes, dp);
            }
            dp.put(currIndex, ans);
            return ans;
        }
    }

    private boolean isValidCode(String code, Set<String> validCodes) {
        return validCodes.contains(code);
    }
}
