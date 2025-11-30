package Practice.src.warmup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode1630 {

    public static void main(String[] args) {

    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            int lowerBound = l[i];
            int upperBound = r[i];
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            Set<Integer> set = new HashSet<>();
            for (int j = lowerBound; j <= upperBound; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                set.add(nums[j]);
            }
            int rangeLength = (upperBound - lowerBound);
            if ((max - min) % rangeLength != 0) {
                res.add(Boolean.FALSE);
            } else {
                int commonDifference = (max - min) / rangeLength;
                int j;
                for (j = 1; j < rangeLength; j++) {
                    if (!set.contains(min + j * commonDifference)) {
                        res.add(Boolean.FALSE);
                        break;
                    }
                }
                if (j == rangeLength) {
                    res.add(Boolean.TRUE);
                }
            }
        }
        return res;
    }
}
