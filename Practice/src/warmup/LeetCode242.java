package Practice.src.warmup;

import java.util.HashMap;
import java.util.Map;

public class LeetCode242 {

    public static void main(String[] args) {

        int num = 1;
//        System.out.println("U+%04X", num);
        System.out.printf("U+%04X", num);
//        String s = "शिवम";
//        s.codePoints().forEach(codePoint -> System.out.println(codePoint));
    }

    public boolean isAnagram(String s, String t) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int unicodeValue = s.charAt(i);
            map.put(unicodeValue, map.getOrDefault(unicodeValue, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            int unicodeValue = t.charAt(i);
            if (map.containsKey(unicodeValue)) {
                map.put(unicodeValue, map.get(unicodeValue) - 1);
                if (map.get(unicodeValue) == 0) {
                    map.remove(unicodeValue);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }
}
