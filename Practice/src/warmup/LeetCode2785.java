package Practice.src.warmup;

import java.util.*;

public class LeetCode2785 {

    public static void main(String[] args) {

        LeetCode2785 test = new LeetCode2785();
        test.sortVowels("lEetcOde");
    }

//    public String sortVowels(String s) {
//
//        Map<Character, Integer> vowelMap = new HashMap<>() {
//            {
//                put('a', 0);
//                put('A', 0);
//                put('e', 0);
//                put('E', 0);
//                put('i', 0);
//                put('I', 0);
//                put('o', 0);
//                put('O', 0);
//                put('u', 0);
//                put('U', 0);
//            }
//        };
//        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.getVowelChar() - p2.getVowelChar());
//        for (int i = 0; i < s.length(); i++) {
//            if (vowelMap.containsKey(s.charAt(i))) {
//                vowelMap.put(s.charAt(i), vowelMap.get(s.charAt(i)) + 1);
//            }
//        }
//        for (Map.Entry<Character, Integer> entry : vowelMap.entrySet()) {
//            if (entry.getValue() > 0) {
//                pq.add(new Pair(entry.getKey(), entry.getValue()));
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            if (vowelMap.containsKey(s.charAt(i))) {
//                Pair pair = pq.peek();
//                sb.append(pair.getVowelChar());
//                if (pair.getFrequency() > 1) {
//                    pair.setFrequency(pair.getFrequency() - 1);
//                } else {
//                    pq.poll();
//                }
//            } else {
//                sb.append(s.charAt(i));
//            }
//        }
//        return sb.toString();
//    }

    public String sortVowels(String s) {

        int[] count = new int[1000];
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                count[s.charAt(i) - 'A']++;
            }
        }
        String vowelsInSortedOrder = "AEIOUaeiou";
        StringBuilder ans = new StringBuilder();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                while (count[vowelsInSortedOrder.charAt(j) - 'A'] == 0) {
                    j++;
                }
                ans.append(vowelsInSortedOrder.charAt(j));
                count[vowelsInSortedOrder.charAt(j) - 'A']--;
            } else {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O'
                || c == 'u' || c == 'U';
    }

    class Pair {

        private Character vowelChar;

        private int frequency;

        public Pair(Character vowelChar, int frequency) {
            this.vowelChar = vowelChar;
            this.frequency = frequency;
        }

        public Character getVowelChar() {
            return vowelChar;
        }

        public void setVowelChar(Character vowelChar) {
            this.vowelChar = vowelChar;
        }

        public int getFrequency() {
            return frequency;
        }

        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }
    }
}
