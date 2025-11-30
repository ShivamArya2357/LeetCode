package Practice.src.contest.Contest3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q1 {

    public static void main(String[] args) {

    }

    public int smallestAbsent(int[] nums) {

        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int sum = Arrays.stream(nums).map(num -> {
            set.add(num);
            return num;
        }).sum();
        int x;
        if (sum % n == 0) {
            x = sum / n + 1;
        } else {
            x = Math.ceilDiv(sum, n);
        }
        while (true) {
            if (!set.contains(x) && x > 0) {
                return x;
            }
            x++;
        }
    }
}
