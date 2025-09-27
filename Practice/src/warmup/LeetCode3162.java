package Practice.src.warmup;

import java.util.HashMap;
import java.util.Map;

public class LeetCode3162 {

    public static void main(String[] args) {

    }

//    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
//
//        int n = nums1.length;
//        int m = nums2.length;
//        int ans = 0;
//        for (int i = 0; i < m; i++) {
//            int b = nums2[i] * k;
//            for (int j = 0; j < n; j++) {
//                if (nums1[j] % b == 0) {
//                    ans++;
//                }
//            }
//        }
//        return ans;
//    }

    public int numberOfPairs(int[] nums1, int[] nums2, int k) {

        int n = nums1.length;
        int m = nums2.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(nums2[i], map.getOrDefault(nums2[i], 0) + 1);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums1[i] % k == 0) {
                int target = nums1[i] / k;
                for (int j = 1; j * j <= target; j++) {
                    if (target % j == 0) {
                        int d1 = j;
                        int d2 = target / j;
                        if (map.containsKey(d1)) {
                            ans += map.get(d1);
                        }
                        if (d1 != d2 && map.containsKey(d2)) {
                            ans += map.get(d2);
                        }
                    }
                }
            }
        }
        return ans;
    }
}
