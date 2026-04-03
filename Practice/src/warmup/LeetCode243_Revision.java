package Practice.src.warmup;

import java.util.HashMap;
import java.util.Map;

public class LeetCode243_Revision {

    public static void main(String[] args) {

        LeetCode243_Revision test = new LeetCode243_Revision();
        String[] words = {"a", "b", "c", "d", "b"};
        String word1 = "b";
        String word2 = "d";
        int ans = test.shortestDistance(words, word1, word2);
        System.out.println(ans);
    }

    public int shortestDistance(String[] words, String word1, String word2) {

        int lastOccIndex1 = -1;
        int lastOccIndex2 = -1;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                if (lastOccIndex2 != -1) {
                    ans = Math.min(ans, i - lastOccIndex2);
                }
                lastOccIndex1 = i;
            } else if (word2.equals(words[i])) {
                if (lastOccIndex1 != -1) {
                    ans = Math.min(ans, i - lastOccIndex1);
                }
                lastOccIndex2 = i;
            }
        }
        return ans;
    }
}
