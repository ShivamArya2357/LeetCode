package Practice.src.warmup;

public class LeetCode3760 {

    public static void main(String[] args) {

    }

    public int maxDistinct(String s) {

        int[] freq = new int[26];
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (freq[s.charAt(i) - 'a'] == 0) {
                ans++;
                freq[s.charAt(i)- 'a'] = 1;
            }
        }
        return ans;
    }
}
