package Practice.src.warmup;

import java.util.HashSet;
import java.util.Set;

public class StringChallenge {

    public static void main(String[] args) {

        StringChallenge test = new StringChallenge();
        String res = test.StringChallenge("");
        System.out.println(res);
    }

    public String StringChallenge(String str) {

        String[] words = str.split(" ");
        for (String word : words) {
            int count = 0;
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < word.length(); i++) {
                Character ch = word.charAt(i);
                if (Character.isDigit(ch)) {
                    if (!isNext2CharDigit(word, i + 1, word.length()) && isUniqueDigit(set, ch)) {
                        count++;
                        set.add(ch);
                    } else {
                        return "false";
                    }
                }
            }
            if (count != 3) {
                return "false";
            }
        }
        return "true";
    }

    private boolean isUniqueDigit(Set<Character> set, Character ch) {
        return !set.contains(ch);
    }

    private boolean isNext2CharDigit(String word, int i, int length) {

        if (i < length && i + 1 < length) {
            return Character.isDigit(word.charAt(i)) && Character.isDigit(word.charAt(i + 1));
        } else {
            return false;
        }
    }
}
