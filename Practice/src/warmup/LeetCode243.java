package Practice.src.warmup;

import java.util.ArrayList;
import java.util.List;

public class LeetCode243 {

    public static void main(String[] args) {

        LeetCode243 test = new LeetCode243();
        String s = "the quick the brown quick brown the frog";
        String word1 = "quick";
        String word2 = "frog";
        int ans = test.shortestWordDistance(s, word1, word2);
        System.out.println(ans);
    }

    public int shortestWordDistance(String s, String word1, String word2) {

        if (word1.equals(word2)) {
            return 0;
        }
        String[] words = s.split(" ");
        int n = words.length;
        int lastWord1Occurrence = -1;
        int lastWord2Occurrence = -1;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            String currentWord = words[i];
            if (word1.equals(currentWord)) {
                lastWord1Occurrence = i;
                if (lastWord2Occurrence != -1) {
                    ans = Math.min(ans, i - lastWord2Occurrence);
                }
            } else if (word2.equals(currentWord)) {
                lastWord2Occurrence = i;
                if (lastWord1Occurrence != -1) {
                    ans = Math.min(ans, i - lastWord1Occurrence);
                }
            }
        }
        return ans;
    }

//    public int shortestWordDistance(String s, String word1, String word2) {
//
//        if (word1.equals(word2)) {
//            return 0;
//        }
//        String[] words = s.split(" ");
//        int n = words.length;
//        List<Integer> word1Occurrences = new ArrayList<>();
//        List<Integer> word2Occurrences = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            String currentWord = words[i];
//            if (word1.equals(currentWord)) {
//                word1Occurrences.add(i);
//            } else if (word2.equals(currentWord)) {
//                word2Occurrences.add(i);
//            }
//        }
//        int ans = Integer.MAX_VALUE;
//        for (Integer element : word1Occurrences) {
//            Integer nextGreaterElementIndex = findNextGreaterElement(word2Occurrences, element);
//            if (nextGreaterElementIndex != -1) {
//                ans = Math.min(ans, Math.abs(element - word2Occurrences.get(nextGreaterElementIndex)) - 1);
//                if (nextGreaterElementIndex - 1 >= 0) {
//                    ans = Math.min(ans, Math.abs(element - word2Occurrences.get(nextGreaterElementIndex - 1) - 1));
//                }
//            }
//        }
//        return ans;
//    }

    private Integer findNextGreaterElement(List<Integer> word2Occurrences, Integer element) {

        int l = 0;
        int h = word2Occurrences.size() - 1;
        int index = word2Occurrences.size() - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (word2Occurrences.get(mid) > element) {
                index = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return index;
    }
}
