package Practice.src.warmup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode890 {

    public static void main(String[] args) {

        LeetCode890 test = new LeetCode890();
        String[] words = new String[]{"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        List<String> res = test.findAndReplacePattern(words, pattern);
        for (String ans : res) {
            System.out.println(ans);
        }
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> res = new ArrayList<>();
        for (String word : words) {
            Map<Character, Character> characterToCharacterMap = new HashMap<>();
            Map<Character, Character> characterToCharacterReverseMap = new HashMap<>();
            if (word.length() == pattern.length()) {
                int i;
                for (i = 0; i < word.length(); i++) {
                    if ((characterToCharacterMap.containsKey(word.charAt(i)) && characterToCharacterMap.get(word.charAt(i)) != pattern.charAt(i))
                    || (characterToCharacterReverseMap.containsKey(pattern.charAt(i)) && characterToCharacterReverseMap.get(pattern.charAt(i)) != word.charAt(i))
                    ) {
                        break;
                    } else {
                        characterToCharacterMap.put(word.charAt(i), pattern.charAt(i));
                        characterToCharacterReverseMap.put(pattern.charAt(i), word.charAt(i));
                    }
                }
                if (i == word.length()) {
                    res.add(word);
                }
            }
        }
        return res;
    }
}
