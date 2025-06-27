package Practice.src.warmup;

import java.util.HashMap;
import java.util.Map;

public class LeetCode2698 {

    public static void main(String[] args) {

    }

    public int punishmentNumber(int n) {

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int num = i * i;
            String numStr = String.valueOf(i * i);
            Map<String, Boolean> dp = new HashMap<>();
            if (isPunishmentNumber(numStr, i, 0, dp)) {
                System.out.println(i);
                ans += num;
            }
        }
        return ans;
    }

    private boolean isPunishmentNumber(String numStr, int num, int sum, Map<String, Boolean> dp) {

        if (numStr.isEmpty()) {
            return (sum == num);
        }
        if (dp.containsKey(numStr)) {
            return dp.get(numStr);
        }
        for (int i = 1; i <= numStr.length(); i++) {
            String newNumStr = numStr.substring(0, i);
            int newNum = Integer.valueOf(newNumStr);
            if (isPunishmentNumber(numStr.substring(i), num, sum + newNum, dp)) {
                dp.put(numStr, true);
                return true;
            }
        }
        dp.put(numStr, false);
        return false;
    }
}
