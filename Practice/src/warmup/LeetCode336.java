package Practice.src.warmup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode336 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> palindromePairs(String[] words) {

        int len = words.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    String newWord = words[i] + words[j];
                    if (isPalindrome(newWord)) {
                        res.add(Arrays.asList(i, j));
                    }
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String word) {

        int i = 0;
        int len = word.length();
        while (i < len && word.charAt(i) == word.charAt(len - i - 1)) {
            i++;
        }
        if (i == len) {
            return true;
        } else {
            return false;
        }
    }
}
