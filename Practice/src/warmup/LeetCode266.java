package Practice.src.warmup;

public class LeetCode266 {

    public static void main(String[] args) {

    }

    public boolean isPalindrome(String s) {

        int[] freq = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        int oddCount = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                oddCount++;
            }
            if (oddCount > 1) {
                return false;
            }
        }
        return true;
    }
}
