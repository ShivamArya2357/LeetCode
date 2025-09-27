package Practice.src.warmup;

import java.util.Arrays;

public class LeetCode1385 {

    public static void main(String[] args) {

        LeetCode1385 test = new LeetCode1385();
        int[] arr1 = {4,5,8};
        int[] arr2 = {10,9,1,8};
        int d = 2;
        int ans = test.findTheDistanceValue(arr1, arr2, d);
        System.out.println(ans);
    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

        int ans = 0;
        Arrays.sort(arr2);
        for (int i = 0; i < arr1.length; i++) {
            int lo = arr1[i] - d;
            int ho = arr1[i] + d;
            if (!found(arr2, lo, ho)) {
                ans++;
            }
        }
        return ans;
    }

    private boolean found(int[] arr2, int lo, int ho) {

        int l = 0;
        int h = arr2.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (arr2[mid] >= lo && arr2[mid] <= ho) {
                return true;
            } else if (arr2[mid] >= ho) {
                h = mid - 1;
            } else if (arr2[mid] <= lo) {
                l = mid + 1;
            }
        }
        return false;
    }
}
