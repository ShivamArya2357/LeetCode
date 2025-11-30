package Practice.src.warmup;

public class LeetCode125 {

    public static void main(String[] args) {

    }

//    public boolean isPalindrome(String s) {
//
//        int len = s.length();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < len; i++) {
//            if (Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
//                sb.append(Character.toLowerCase(s.charAt(i)));
//            }
//        }
//        return isPalindromeStr(sb.toString());
//    }

    public boolean isPalindrome(String s) {

        int l = 0;
        int len = s.length();
        int h = len - 1;
        while (l < h) {
            while (l < h && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (l < h && !Character.isLetterOrDigit(s.charAt(h))) {
                h--;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(h))) {
                return false;
            }
            l++;
            h--;
        }
        return true;
    }

    private boolean isPalindromeStr(String s) {

        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
