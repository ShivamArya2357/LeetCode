package Practice.src.warmup;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1255 {

    public static void main(String[] args) {

        String[] words = new String[]{"leetcode"};
        char[] letters = new char[]{'l','e','t','c','o','d'};
        int[] score = new int[]{0,0,1,1,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0};
        int ans = maxScoreWords(words, letters, score);
        System.out.println(ans);
    }

    public static int maxScoreWords(String[] words, char[] letters, int[] score) {

        int totalWordsCount = words.length;
        int totalLettersCount = letters.length;
        int totalWordsSubsetCount = (1 << totalWordsCount);
        Map<Integer, Integer> wordToScoreMap = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < totalWordsCount; i++) {
            String currentWord = words[i];
            int wordLength = currentWord.length();
            int currentSum = 0;
            for (int j = 0; j < wordLength; j++) {
                currentSum += score[currentWord.charAt(j) - 'a'];
            }
            wordToScoreMap.put(i, currentSum);
        }
        for (int i = 0; i < totalWordsSubsetCount; i++) {
            Map<Character, Integer> letterCountMap = new HashMap<>();
            for (int j = 0; j < totalLettersCount; j++) {
                letterCountMap.put(letters[j], letterCountMap.getOrDefault(letters[j], 0) + 1);
            }
            int currentSum = 0;
            for (int j = 0; j < totalWordsCount; j++) {
                if (isBitSet(i, j)) {
                    String currentWord = words[j];
                    int wordLength = currentWord.length();
                    int k;
                    for (k = 0; k < wordLength; k++) {
                        if (letterCountMap.containsKey(currentWord.charAt(k))) {
                            letterCountMap.put(currentWord.charAt(k), letterCountMap.get(currentWord.charAt(k)) - 1);
                            if (letterCountMap.get(currentWord.charAt(k)) == 0) {
                                letterCountMap.remove(currentWord.charAt(k));
                            }
                        } else {
                            break;
                        }
                    }
                    if (k == wordLength) {
                        currentSum += wordToScoreMap.get(j);
                    }
                }
            }
            ans = Math.max(ans, currentSum);
        }
        return ans;
    }

    private static boolean isBitSet(int i, int j) {
        return (i & (1 << j)) > 0;
    }
}
