package Practice.src.warmup;

import java.util.*;

public class LeetCode451 {

    public static void main(String[] args) {

        LeetCode451 test = new LeetCode451();
        String s = "tree";
        String ans = test.frequencySort3(s);
        System.out.println(ans);
    }

    public String frequencySort(String s) {

        Map<Character, Integer> freqMap = new HashMap<>();
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
                (c1, c2) -> freqMap.get(c2) - freqMap.get(c1)
        );
        for (int i = 0; i < s.length(); i++) {
            freqMap.computeIfPresent(s.charAt(i), (k, v) -> v + 1);
            freqMap.putIfAbsent(s.charAt(i), 1);
        }
        List<Character> uniqueChars = new ArrayList<>(freqMap.keySet());
        for (Character uniqueChar : uniqueChars) {
            maxHeap.offer(uniqueChar);
        }
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Character ch = maxHeap.poll();
            int freqCnt = freqMap.get(ch);
            for (int i = 0; i < freqCnt; i++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public String frequencySort2(String s) {

        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            freqMap.computeIfPresent(s.charAt(i), (k, v) -> v + 1);
            freqMap.putIfAbsent(s.charAt(i), 1);
        }
        List<Character> uniqueChars = new ArrayList<>(freqMap.keySet());
        Collections.sort(uniqueChars, (c1, c2) -> freqMap.get(c2) - freqMap.get(c1));
        StringBuilder sb = new StringBuilder();
        for (Character uniqueChar : uniqueChars) {
            int count = freqMap.get(uniqueChar);
            for (int i = 0; i < count; i++) {
                sb.append(uniqueChar);
            }
        }
        return sb.toString();
    }

    public String frequencySort3(String s) {

        Map<Character, Integer> freqMap = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < s.length(); i++) {
            freqMap.computeIfPresent(s.charAt(i), (k, v) -> v + 1);
            freqMap.putIfAbsent(s.charAt(i), 1);
        }
        List<Character>[] buckets = new ArrayList[n + 1];
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (buckets[value] == null) {
                buckets[value] = new ArrayList<>();
            }
            List<Character> existingChar = buckets[value];
            existingChar.add(key);
        }
        StringBuilder ans = new StringBuilder();
        for (int i = n; i >= 1; i--) {
            if (buckets[i] != null) {
                for (Character key : buckets[i]) {
                    for (int j = 0; j < i; j++) {
                        ans.append(key);
                    }
                }
            }
        }
        return ans.toString();
    }
}
