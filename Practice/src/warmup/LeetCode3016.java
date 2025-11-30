package Practice.src.warmup;

import java.util.*;

public class LeetCode3016 {

    public static void main(String[] args) {

        int ans = minimumPushes("abcde");
        System.out.println(ans);
    }

//    public static int minimumPushes(String word) {
//
//        Integer[] freq = new Integer[26];
//        Arrays.fill(freq, 0);
//        for (int i = 0; i < word.length(); i++) {
//            freq[word.charAt(i) - 'a']++;
//        }
//        Arrays.sort(freq, Collections.reverseOrder());
//        int ans = 0;
//        for (int i = 0; i < 26; i++) {
//            if (freq[i] > 0) {
//                ans += freq[i] * (i / 8 + 1);
//            }
//        }
//        return ans;
//    }

    public static int minimumPushes(String word) {

        Map<Character, Integer> frequencyMap = new HashMap<>();
        int len = word.length();
        for (int i = 0; i < len; i++) {
            frequencyMap.put(word.charAt(i), frequencyMap.getOrDefault(word.charAt(i), 0) + 1);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        priorityQueue.addAll(frequencyMap.values());
        int index = 0;
        int ans = 0;
        while (!priorityQueue.isEmpty()) {
            ans += (index / 8 + 1) * priorityQueue.poll();
            index++;
        }
        return ans;
    }
}
