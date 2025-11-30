package Practice.src.warmup;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1415 {

    Character[] charsToUse = new Character[]{'a', 'b', 'c'};

    int count = 0;

    String ans = null;

    public static void main(String[] args) {

        LeetCode1415 test = new LeetCode1415();
        test.getHappyString(3, 9);
    }

    public String getHappyString(int n, int k) {

        StringBuilder sb = new StringBuilder();
        List<String> happyStrings = new ArrayList<>();
        generateHappyStrings(sb, null, n, k);
        for (String happyString : happyStrings) {
            System.out.println(happyString);
        }
        return null;
//        return happyStrings.get(k - 1);
    }

    private void generateHappyStrings(
            StringBuilder sb, Character prevChar, int n, int k
    ) {

        if (sb.length() == n) {
            count++;
            if (count == k) {
                ans = sb.toString();
            }
        } else {
            for (int i = 0; i < 3; i++) {
                if (!charsToUse[i].equals(prevChar)) {
                    sb.append(charsToUse[i]);
                    generateHappyStrings(sb, charsToUse[i], n, k);
                    if (ans != null) {
                        return;
                    } else {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                }
            }
        }
    }
}
