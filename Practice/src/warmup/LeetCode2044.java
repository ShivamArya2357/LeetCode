package Practice.src.warmup;

public class LeetCode2044 {

//    https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/description/

    public static void main(String[] args) {


    }

    // First Approach
//    public int countMaxOrSubsets(int[] nums) {
//
//        int len = nums.length;
//        int totalSubSets = (1 << len) - 1;
//        Map<Integer, Integer> subsetBitwiseOrCountMap = new HashMap<>();
//        int maxSubsetBitwiseOr = 0;
//        for (int i = 1; i <= totalSubSets; i++) {
//            int num = i;
//            int subsetBitwiseOr = 0;
//            for (int j = 0; j < len; j++) {
//                if ((num & (1 << j)) != 0) {
//                    subsetBitwiseOr |= nums[j];
//                }
//            }
//            subsetBitwiseOrCountMap.put(subsetBitwiseOr,
//                    subsetBitwiseOrCountMap.getOrDefault(subsetBitwiseOr, 0) + 1
//            );
//            maxSubsetBitwiseOr = Math.max(maxSubsetBitwiseOr, subsetBitwiseOr);
//        }
//        return subsetBitwiseOrCountMap.get(maxSubsetBitwiseOr);
//    }

    // Second Approach
//    public int countMaxOrSubsets(int[] nums) {
//
//        int len = nums.length;
//        int maxOr = 0;
//        for (int i = 0; i < len; i++) {
//            maxOr |= nums[i];
//        }
//
//    }
}
