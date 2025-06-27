package Practice.src.contest.Contest2;

import java.util.HashMap;
import java.util.Map;

public class Q1 {

    public static void main(String[] args) {

    }

    public String findValidPair(String s) {

        Map<Character, Integer> frequencyMap = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            frequencyMap.put(s.charAt(i), frequencyMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) != s.charAt(i - 1) && frequencyMap.get(s.charAt(i)) == s.charAt(i) - '0' &&
                    frequencyMap.get(s.charAt(i - 1)) == s.charAt(i - 1) - '0'
            ) {
                StringBuilder sb = new StringBuilder();
                sb.append(s.charAt(i - 1));
                sb.append(s.charAt(i));
                return sb.toString();
            }
        }
        return "";
    }
}
