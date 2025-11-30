package Practice.src.interview.MMT;

/**
 Problem: Palindromic Partitioning with Minimum Cuts
 Given a string s, partition it into substrings such that every substring is a palindrome.
 Return the minimum number of cuts needed to achieve this partitioning.
 🔍 Constraints:
 1 <= s.length <= 1000


 The string consists of lowercase English letters only.

 input = "abccbc"
 Palindromic partitions:
 [“a”, “b”, “c”, “c”, “b”, “c”] → 5 cuts ❌


 [“a”, “b”, “cc”, “b”, “c”] → 4 cuts ❌


 [“a”, “bccb”, “c”] → ✅ 2 cuts


 🔚 Output: 2
 1.
 [a, bccbc]
 [ab, ccbc]
 [abc, cbc]
 [abcc, bc]
 [abcb, c]
 [abcbc]

 2.
 [b, ccbc]
 [bc, cbc]




 input = "ababbbabba
 input = "ababbbabbababa"
 Optimal palindromic partitioning:
 [“a”, “babbbab”, “bababa”]


 🔚 Output: 3
 */
public class OptimalPalindromic {

    public static void main(String[] args) {

    }

//    public int minCuts(String s) {
//
//        int len = s.length();
//        int ans = Integer.MAX_VALUE;
//        for (int i = 0; i < len; i++) {
//            for (int size = 1; size <= len; size++) {
//                String substr = s.substring(i, size);
//                if (isPalindrome(substr)) {
//                    String leftPart = s.substring(0, i);
//                    String rightPart = s.substring(size);
//                    if (isPalindrome(leftPart) && isPalindrome(rightPart)) {
//                        ans = Math.max(ans, )
//                    }
//                }
//            }
//        }
//    }

    private boolean isPalindrome(String s) {

        int l = 0;
        int h = s.length() - 1;
        while (l < h) {
            if (s.charAt(l) != s.charAt(h)) {
                return false;
            }
            l++;
            h--;
        }
        return true;
    }
}
