package Practice.src.warmup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeetCode2824 {

    public static void main(String[] args) {

        LeetCode2824 test = new LeetCode2824();
        List<Integer> nums = Arrays.asList(-6,2,5,-2,-7,-1,3);
        int target = -2;
        int ans = test.countPairs(nums, target);
        System.out.println(ans);
    }

//    public int countPairs(List<Integer> nums, int target) {
//
//        int ans = 0;
//        int n = nums.size();
//        Collections.sort(nums);
//        for (int j = 1; j < n; j++) {
//            int key = target - nums.get(j);
//            ans += smallerElement(nums, 0,j - 1, key);
//        }
//        return ans;
//    }

    public int countPairs(List<Integer> nums, int target) {

        int ans = 0;
        int n = nums.size();
        Collections.sort(nums);
        int l = 0;
        int h = n - 1;
        while (l < h) {
            int sum = nums.get(l) + nums.get(h);
            if (sum < target) {
                ans += (h - l);
                l++;
            } else {
                h--;
            }
        }
        return ans;
    }

    private int smallerElement(List<Integer> nums, int l, int h, int key) {

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums.get(mid) >= key) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
