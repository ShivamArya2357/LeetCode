package Practice.src.warmup;

import java.util.HashSet;
import java.util.Set;

public class LeetCode1780 {

    public static void main(String[] args) {

        LeetCode1780 test = new LeetCode1780();
        boolean ans = test.checkPowersOfThree(6574365);
        System.out.println(ans);
    }

    public boolean checkPowersOfThree(int n) {

        int power = logBase3(n);
        Set<Integer> set = new HashSet<>();
        set.add(power);
        n -= (int) Math.pow(3, power);
        while (n > 0) {
            power = logBase3(n);
            while (set.contains(power)) {
                power--;
            }
            if (power >= 0) {
                n -= (int) Math.pow(3, power);
                set.add(power);
            } else {
                break;
            }
        }
        System.out.println(n);
        return n == 0;
    }

    public int logBase3(int n) {
        return (int) (Math.log(n) / Math.log(3));
    }
}
