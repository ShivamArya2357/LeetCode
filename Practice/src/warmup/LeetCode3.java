package Practice.src.warmup;

import java.util.HashMap;
import java.util.Map;

public class LeetCode3 {

    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> lastOccMap = new HashMap<>();
        int l = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (lastOccMap.containsKey(s.charAt(i)) && lastOccMap.get(s.charAt(i)) >= l) {
                l = lastOccMap.get(s.charAt(i)) + 1;
            }
            lastOccMap.put(s.charAt(i), i);
            ans = Math.max(ans, i - l + 1);
        }
        return ans;
    }
}
