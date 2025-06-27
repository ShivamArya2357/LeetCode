package Practice.src.warmup;

import java.util.ArrayList;
import java.util.Map;

public class LeetCode28 {

//    public static void main(String[] args) {
//
//        LeetCode28 test = new LeetCode28();
//        int ans = test.strStr("abcab", "ab");
//        System.out.println(ans);
//    }

    public int strStr(String haystack, String needle) {

        int[] lps = buildLpsArr(needle);
        int len1 = haystack.length();
        int len2 = needle.length();
        int i = 0;
        int j = 0;
        while (i < len1) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    j = 0;
                    i++;
                }
            }
        }
        return j < len2 ? -1 : i - len2;
    }

//    public static void main(String[] args) {
//
//        LeetCode28 test = new LeetCode28();
//        ArrayList<Integer> ans = test.search("aaba", "aabaacaadaabaaba");
//        System.out.println(ans);
//    }

    ArrayList<Integer> search(String pat, String txt) {
        // your code here

        int[] lps = buildLpsArr(pat);
        int len1 = txt.length();
        int len2 = pat.length();
        int i = 0;
        int j = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while (i < len1) {
            if (j == len2) {
                ans.add(i - len2);
                j = lps[j - 1];
            }
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            } else {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    j = 0;
                    i++;
                }
            }
        }
        if (j == len2) {
            ans.add(i - len2);
        }
        return ans;
    }

    public static void main(String[] args) {

        LeetCode28 test = new LeetCode28();
        int ans = test.longestPrefixSuffix("aaaa");
        System.out.println(ans);
    }

    int longestPrefixSuffix(String s) {
        // code here
        int[] lps = buildLpsArr(s);
        return lps[s.length() - 1];
    }

    public int[] buildLpsArr(String needle) {

        int len = needle.length();
        int[] lps = new int[len];
        int j = 0;
        for (int i = 1; i < len; ) {
            if (needle.charAt(i) == needle.charAt(j)) {
                lps[i++] = ++j;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    lps[i++] = 0;
                }
            }
        }
        return lps;
    }
}
