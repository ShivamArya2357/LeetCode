package Practice.src.warmup;

import java.util.HashSet;
import java.util.Set;

public class LeetCode2427 {

    public static void main(String[] args) {

    }

//    public int commonFactors(int a, int b) {
//
//        Set<Integer> commonFactors = new HashSet<>();
//        for (int i = 1; i * i <= a; i++) {
//            if (a % i == 0) {
//                int d1 = i;
//                int d2 = a / i;
//                commonFactors.add(d1);
//                commonFactors.add(d2);
//            }
//        }
//        int ans = 0;
//        for (int i = 1; i * i <= b; i++) {
//            if (b % i == 0) {
//                int d1 = i;
//                int d2 = b / i;
//                if (commonFactors.contains(d1)) {
//                    ans++;
//                }
//                if (d1 != d2 && commonFactors.contains(d2)) {
//                    ans++;
//                }
//            }
//        }
//        return ans;
//    }

    public int commonFactors(int a, int b) {

        int gcd = findGcd(a, b);
        int ans = 0;
        for (int i = 1; i * i <= gcd; i++) {
            if (gcd % i == 0) {
                ans++;
                if (i != gcd / i) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private int findGcd(int a, int b) {

        if (b == 0) {
            return a;
        } else {
            return findGcd(b, a % b);
        }
    }
}
