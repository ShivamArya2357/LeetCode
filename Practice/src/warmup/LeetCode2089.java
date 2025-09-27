package Practice.src.warmup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode2089 {

    public static void main(String[] args) {

        LeetCode2089 test = new LeetCode2089();
        int[] nums = {1,2,5,2,3};
        int target = 5;
        List<Integer> ans = test.targetIndices(nums, target);
        System.out.println(ans);
    }

//    public List<Integer> targetIndices(int[] nums, int target) {
//
//        int n = nums.length;
//        Arrays.sort(nums);
//        int leftIndex = getLeftIndex(nums, 0, n - 1, target);
//        List<Integer> ans = new ArrayList<>();
//        if (leftIndex == n || nums[leftIndex] != target) {
//            return ans;
//        }
//        int rightIndex = getRightIndex(nums, 0, n - 1, target);
//        for (int i = leftIndex; i <= rightIndex; i++) {
//            ans.add(i);
//        }
//        return ans;
//    }
//
//    private int getLeftIndex(int[] nums, int l, int h, int target) {
//
//        int n = nums.length;
//        while (l <= h) {
//            int mid = l + (h - l) / 2;
//            if (nums[mid] >= target) {
//                h = mid - 1;
//            } else {
//                l = mid + 1;
//            }
//        }
//        return l;
//    }
//
//    private int getRightIndex(int[] nums, int l, int h, int target) {
//
//        int n = nums.length;
//        while (l <= h) {
//            int mid = l + (h - l) / 2;
//            if (nums[mid] == target) {
//
//            }
//            if (nums[mid] > target) {
//                h = mid - 1;
//            } else {
//                l = mid + 1;
//            }
//        }
//        return h;
//    }

    public List<Integer> targetIndices(int[] nums, int target) {

        int n = nums.length;
        int lt = 0;
        int eq = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < target) {
                lt++;
            } else if (nums[i] == target) {
                eq++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < eq; i++) {
            ans.add(lt + i);
        }
        return ans;
    }
}
