package Practice.src.warmup;

import java.util.HashSet;
import java.util.Set;

public class LeetCode1248 {

    public static void main(String[] args) {

        LeetCode1248 test = new LeetCode1248();
        int[] nums = {2044,96397,50143};
        int ans = test.numberOfSubarrays(nums, 1);
        System.out.println(ans);
    }

//    public int numberOfSubarrays(int[] nums, int k) {
//
//        int n = nums.length;
//        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            int oddCount = 0;
//            int end = n;
//            int j;
//            for (j = i; j < n; j++) {
//                if (nums[j] % 2 == 1) {
//                    if (oddCount < k) {
//                        oddCount++;
//                        if (oddCount == k && end == n) {
//                            end = j;
//                        }
//                    } else {
//                        break;
//                    }
//                }
//            }
//            ans += (j - end);
//        }
//        return ans;
//    }

    public int numberOfSubarrays(int[] nums, int k) {

        int n = nums.length;
        int ans = 0;
        int r = 0;
        int oddCount = 0;
        int evenCount = 0;
        for (int l = 0; l < n; l++) {
            while (r < n && oddCount < k) {
                if (nums[r] % 2 == 1) {
                    oddCount++;
                }
                r++;
            }
            if (oddCount < k) {
                break;
            }
            if (evenCount == 0) {
                int ro = r;
                while (ro < n && nums[ro] % 2 == 0) {
                    evenCount++;
                    ro++;
                }
            }
            ans += evenCount + 1;
            if (nums[l] % 2 == 1) {
                oddCount--;
                evenCount = 0;
            }
        }
        return ans;
    }
}
