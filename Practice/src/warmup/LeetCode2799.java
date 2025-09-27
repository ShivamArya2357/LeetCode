package Practice.src.warmup;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode2799 {

    public static void main(String[] args) {

        LeetCode2799 test = new LeetCode2799();
        int[] nums = {1786,1786,1786,114};
        int ans = test.countCompleteSubarrays(nums);
        System.out.println(ans);
    }

//    public int countCompleteSubarrays(int[] nums) {
//
//        int n = nums.length;
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < n; i++) {
//            set.add(nums[i]);
//        }
//        int totalUniqueElements = set.size();
//        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            set = new HashSet<>();
//            for (int j = i; j < n; j++) {
//                set.add(nums[j]);
//                if (set.size() == totalUniqueElements) {
//                    ans++;
//                }
//            }
//        }
//        return ans;
//    }

    public int countCompleteSubarrays(int[] nums) {

        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        int totalUniqueElements = set.size();
        int start = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            int count = getUniqueCount(map);
            if (count == totalUniqueElements) {
                ans += 1 + (n - i - 1);
                map.put(nums[start], map.get(nums[start]) - 1);
                if (map.get(nums[start]) == 0) {
                    map.remove(nums[start]);
                }
                start++;
                while (start < n) {
                    count = getUniqueCount(map);
                    if (count == totalUniqueElements) {
                        ans += 1 + (n - i - 1);
                        map.put(nums[start], map.get(nums[start]) - 1);
                        if (map.get(nums[start]) == 0) {
                            map.remove(nums[start]);
                        }
                        start++;
                    } else {
                        break;
                    }
                }
            }
        }
        return ans;
    }

    private static int getUniqueCount(Map<Integer, Integer> map) {
        return map.size();
    }
}
