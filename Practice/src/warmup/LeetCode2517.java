//package Practice.src.warmup;
//
//import java.util.Arrays;
//
//public class LeetCode2517 {
//
//    public static void main(String[] args) {
//
//    }
//
//    public int maximumTastiness(int[] price, int k) {
//
//        int n = price.length;
//        if (n < k) {
//            return 0;
//        } {
//            Arrays.sort(price);
//            int l = price[n - 1] - price[n - 2];
//            int h = price[n - 1] - price[0];
//            while (l <= h) {
//                int mid = l + (h - l) / 2;
//                if (isPossible(price, n, k, mid)) {
//
//                } else {
//
//                }
//            }
//        }
//    }
//
//    private boolean isPossible(int[] price, int n, int k, int mid) {
//
//
//    }
//}
