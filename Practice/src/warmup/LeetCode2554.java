package Practice.src.warmup;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode2554 {

    public static void main(String[] args) {

        LeetCode2554 test = new LeetCode2554();
        int[] banned = {1,2,3,4,5,6,7};
        int n = banned.length;
        int maxSum = 1;
        int ans = test.maxCount(banned, n, maxSum);
        System.out.println(ans);
    }

    public int maxCount(int[] banned, int n, int maxSum) {

        Set<Integer> set = new HashSet<>();
        Arrays.stream(banned).map(ele -> {
            set.add(ele);
            return ele;
        }).toArray();
        int sum = 0;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                sum += i;
                if (sum <= maxSum) {
                    ans++;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }
}
