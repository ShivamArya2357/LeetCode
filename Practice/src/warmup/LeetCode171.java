package Practice.src.warmup;

import java.util.HashMap;
import java.util.Map;

public class LeetCode171 {

    public static void main(String[] args) {

    }

    public int titleToNumber(String columnTitle) {

        int num = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            int val = columnTitle.charAt(i) - 'A' + 1;
            num = (num * 26 + val);
        }
        return num;
    }
}
