package Practice.src.warmup;

import java.util.*;

public class LeetCode349 {

    public static void main(String[] args) {

    }

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            set.add(nums1[i]);
        }
        int m = nums2.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            if (set.contains(nums2[i])) {
                ans.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
