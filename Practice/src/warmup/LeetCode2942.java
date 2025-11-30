package Practice.src.warmup;

import java.util.ArrayList;
import java.util.List;

public class LeetCode2942 {

    public static void main(String[] args) {

    }

    public List<Integer> findWordsContaining(String[] words, char x) {

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.indexOf(x) != -1) {
                res.add(i);
            }
        }
        return res;
    }
}
