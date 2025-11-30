package Practice.src.warmup;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode219 {

    public static void main(String[] args) {


    }

//    public boolean containsNearbyDuplicate(int[] nums, int k) {
//
//        Map<Integer, Integer> map = new HashMap<>();
//        int n = nums.length;
//        for (int i = 0; i < n; i++) {
//            if (map.containsKey(nums[i])) {
//                int prevOccurrence = map.get(nums[i]);
//                if (i - prevOccurrence <= k) {
//                    return true;
//                }
//            }
//            map.put(nums[i], i);
//        }
//        return false;
//    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> window = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (window.contains(nums[i])) {
                return true;
            }
            window.add(nums[i]);
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }
        return false;
    }
}
