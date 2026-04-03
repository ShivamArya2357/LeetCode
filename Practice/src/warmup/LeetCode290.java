package Practice.src.warmup;

import java.util.HashMap;
import java.util.Map;

public class LeetCode290 {

    public static void main(String[] args) {

        LeetCode290 test = new LeetCode290();
        String pattern = "abba";
        String s = "dog cat cat fish";
        boolean ans = test.wordPattern(pattern, s);
        System.out.println(ans);
    }

    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        } else {
            int n = pattern.length();
            Map<Character, String> patternToWordMap = new HashMap<>();
            Map<String, Character> wordToPatternMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                char patternKey = pattern.charAt(i);
                String wordKey = words[i];
                if ((patternToWordMap.containsKey(patternKey) && !patternToWordMap.get(patternKey).equals(wordKey))
                    || (wordToPatternMap.containsKey(wordKey) && !wordToPatternMap.get(wordKey).equals(patternKey))
                ) {
                    return false;
                }
                patternToWordMap.put(patternKey, wordKey);
                wordToPatternMap.put(wordKey, patternKey);
            }
            return true;
        }
    }
}
