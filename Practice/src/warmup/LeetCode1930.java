package Practice.src.warmup;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode1930 {

    public static void main(String[] args) {

    }

    public int countPalindromicSubsequence(String s) {

        int len = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);
        for (int i = 0; i < len; i++) {
            if (first[s.charAt(i) - 'a'] == -1) {
                first[s.charAt(i) - 'a'] = i;
            }
            last[s.charAt(i) - 'a'] = i;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (first[i] != -1) {
                int firstIndex = first[i];
                int lastIndex = last[i];
                Set<Character> set = new HashSet<>();
                for (int j = firstIndex + 1; j < lastIndex; j++) {
                    set.add(s.charAt(j));
                }
                ans += set.size();
            }
        }
        return ans;
    }
}
