package Practice.src.warmup;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1358 {

    public static void main(String[] args) {

        LeetCode1358 test = new LeetCode1358();
        int ans = test.numberOfSubstrings("acbbcac");
        System.out.println(ans);
    }

    public int numberOfSubstrings(String s) {

        int n = s.length();
        int[] freq = new int[3];
        int ans = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
            if (getSize(freq) == 3) {
                ans += n - i;
                ch = s.charAt(start);
                freq[ch - 'a']--;
                start++;
                while (start < n && getSize(freq) == 3) {
                    ans += (n - i);
                    ch = s.charAt(start);
                    freq[ch - 'a']--;
                    start++;
                }
            }
        }
        return ans;
    }

    private int getSize(int[] freq) {

        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (freq[i] > 0) {
                count++;
            }
        }
        return count;
    }
}
