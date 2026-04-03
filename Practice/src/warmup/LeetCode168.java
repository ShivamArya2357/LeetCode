package Practice.src.warmup;

import java.util.HashMap;
import java.util.Map;

public class LeetCode168 {

    public static void main(String[] args) {

    }

    public String convertToTitle(int columnNumber) {

        Map<Integer, Character> numberToCharMap = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            numberToCharMap.put(i, (char)(i + 'A'));
        }
        columnNumber--;
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            Character ch = numberToCharMap.get(columnNumber % 26);
            sb.append(ch);
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}
