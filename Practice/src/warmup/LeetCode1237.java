//package Practice.src.warmup;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class LeetCode1237 {
//
//    public static void main(String[] args) {
//
//    }
//
//     class CustomFunction {
//          // Returns f(x, y) for any given positive integers x and y.
//          // Note that f(x, y) is increasing with respect to both x and y.
//          // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
//          public int f(int x, int y);
//     };
//
//    class Solution {
//
//        public List<List<Integer>> findSolution(CustomFunction func, int z) {
//
//            List<List<Integer>> ans = new ArrayList<>();
//            for (int x = 1; x <= 1000; x++) {
//                if (func.f(x, 1) > z) {
//                    break;
//                }
//                if (func.f(x, 1000) < z) {
//                    continue;
//                }
//                int l = 1;
//                int h = 1000;
//                while (l <= h) {
//                    int mid = l + (h - l) / 2;
//                    if (func.f(x, mid) < z) {
//                        l = mid + 1;
//                    } else if (func.f(x, mid) > z) {
//                        h = mid - 1;
//                    } else {
//                        ans.add(Arrays.asList(x, mid));
//                    }
//                }
//            }
//            return ans;
//        }
//    }
//}
