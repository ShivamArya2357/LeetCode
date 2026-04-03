package Practice.src.warmup;

import java.util.HashMap;
import java.util.Map;

public class LeetCode13 {

    public static void main(String[] args) {

        LeetCode13 test = new LeetCode13();
        int ans = test.romanToInt("MCMXCIV");
        System.out.println(ans);
    }

    public int romanToInt(String s) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int i = 0;
        int len = s.length();
        int ans = 0;
        while (i < len) {
            if (s.charAt(i) == 'I') {
                if (i + 1 < len) {
                    if (s.charAt(i + 1) == 'V') {
                        ans += 4;
                        i += 2;
                        continue;
                    } else if (s.charAt(i + 1) == 'X') {
                        ans += 9;
                        i += 2;
                        continue;
                    }
                }
                ans += 1;
                i++;
            } else if (s.charAt(i) == 'X') {
                if (i + 1 < len) {
                    if (s.charAt(i + 1) == 'L') {
                        ans += 40;
                        i += 2;
                        continue;
                    } else if (s.charAt(i + 1) == 'C') {
                        ans += 90;
                        i += 2;
                        continue;
                    }
                }
                ans += 10;
                i++;
            } else if (s.charAt(i) == 'C') {
                if (i + 1 < len) {
                    if (s.charAt(i + 1) == 'D') {
                        ans += 400;
                        i += 2;
                        continue;
                    } else if (s.charAt(i + 1) == 'M') {
                        ans += 900;
                        i += 2;
                        continue;
                    }
                }
                ans += 100;
                i++;
            } else {
                ans += map.get(s.charAt(i));
                i++;
            }
        }
        return ans;
    }
}
