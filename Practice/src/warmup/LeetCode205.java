package Practice.src.warmup;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode205 {

    public static void main(String[] args) {

        LeetCode205 test = new LeetCode205();
        boolean ans = test.isIsomorphic("paper", "title");
        System.out.println(ans);
    }

//    public boolean isIsomorphic(String s, String t) {
//
//        if (s.length() != t.length()) {
//            return false;
//        } else {
//            Set<Character> set = new HashSet<>();
//            Map<Character, Character> map = new HashMap<>();
//            for (int i = 0; i < s.length(); i++) {
//                if (map.containsKey(s.charAt(i))) {
//                    Character existingMapping = map.get(s.charAt(i));
//                    if (t.charAt(i) != existingMapping) {
//                        return false;
//                    }
//                } else {
//                    if (!set.contains(t.charAt(i))) {
//                        map.put(s.charAt(i), t.charAt(i));
//                        set.add(t.charAt(i));
//                    } else {
//                        return false;
//                    }
//                }
//            }
//        }
//        return true;
//    }

    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        } else {
            int[] m1 = new int[256];
            int[] m2 = new int[256];
            for (int i = 0; i < s.length(); i++) {
                if (m1[s.charAt(i)] != m2[t.charAt(i)]) {
                    return false;
                }
                m1[s.charAt(i)] = i + 1;
                m2[t.charAt(i)] = i + 1;
            }
        }
        return true;
    }
}
