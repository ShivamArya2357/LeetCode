package Practice.src.warmup;

public class LeetCode2396 {

    public static void main(String[] args) {

        LeetCode2396 test = new LeetCode2396();
        boolean ans = test.isStrictlyPalindromic(17);
        System.out.println(ans);
    }

    public boolean isStrictlyPalindromic(int n) {

        for (int b = 2; b <= n - 2; b++) {
            String baseBNum = convertInBaseB(n, b);
            if (!isPalindrome(baseBNum)) {
                return false;
            }
        }
        return true;
    }

    private boolean isPalindrome(String baseBNum) {

        int n = baseBNum.length();
        int l = 0;
        int h = n - 1;
        while (l < n && h >= 0 && l <= h && baseBNum.charAt(l) == baseBNum.charAt(h)) {
            l++;
            h--;
        }
        return l > h;
    }

    private String convertInBaseB(int n, int b) {

        StringBuilder baseBNum = new StringBuilder();
        while (n > 0) {
            baseBNum.append(n % b);
            n = n / b;
        }
        return baseBNum.reverse().toString();
    }
}
