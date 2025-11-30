package Practice.src.warmup;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LeetCode76 {

    public static void main(String[] args) {

        LeetCode76 test = new LeetCode76();
        String ans = test.minWindow("a", "aa");
        System.out.println(ans);
    }

    public String minWindow(String s, String t) {

        int n = s.length();
        int m = t.length();
        Map<Character, Integer> freqMap1 = new HashMap<>();
        Map<Character, Integer> freqMap2 = new HashMap<>();
        for (int i = 0; i < m; i++) {
            Character ch = t.charAt(i);
            freqMap1.put(ch, freqMap1.getOrDefault(ch, 0) + 1);
        }
        int i = 0;
        int start = 0;
        int ans = Integer.MAX_VALUE;
        int f = 0;
        int l = -1;
        while (i < n) {
            Character ch = s.charAt(i);
            freqMap2.put(ch, freqMap2.getOrDefault(ch, 0) + 1);
            if (frequencyMatch(freqMap1, freqMap2)) {
                if (ans > (i - start + 1)) {
                    ans = i - start + 1;
                    f = i;
                    l = start;
                }
                removeChar(s, start, freqMap2);
                start++;
                while (start < n && frequencyMatch(freqMap1, freqMap2)) {
                    if (ans > (i - start + 1)) {
                        ans = i - start + 1;
                        f = i;
                        l = start;
                    }
                    removeChar(s, start, freqMap2);
                    start++;
                }
            }
            i++;
        }
        return s.substring(f, l + 1);
    }

    private static void removeChar(String s, int start, Map<Character, Integer> freqMap2) {
        Character ch = s.charAt(start);
        freqMap2.put(ch, freqMap2.get(ch) - 1);
        if (freqMap2.get(ch) == 0) {
            freqMap2.remove(ch);
        }
    }

    private static boolean frequencyMatch(
            Map<Character, Integer> freqMap1, Map<Character, Integer> freqMap2
    ) {

        for (Map.Entry<Character, Integer> entry : freqMap1.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (!freqMap2.containsKey(key) || !(freqMap2.get(key) >= value)) {
                return false;
            }
        }
        return true;
    }
}
