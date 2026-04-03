package Practice.src.warmup;

import java.util.HashSet;
import java.util.Set;

public class LeetCode202 {

    public static void main(String[] args) {

        LeetCode202 test = new LeetCode202();
        boolean ans = test.isHappy(2);
        System.out.println(ans);
    }

    public boolean isHappy(int n) {

        if (n == 1) {
            return true;
        } else {
            Set<Integer> set = new HashSet<>();
            while (!set.contains(n)) {
                set.add(n);
                n = calSum(n);
                if (n == 1) {
                    return true;
                }
            }
            return false;
        }
    }

    private int calSum(int n) {

        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}
