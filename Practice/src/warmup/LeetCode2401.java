package Practice.src.warmup;

public class LeetCode2401 {

    public static void main(String[] args) {

        LeetCode2401 test = new LeetCode2401();
        int[] nums = {986007351,128892374,427803977,580618971,570259454,813643780,654079604,622205338,351775125,700867396};
        int ans = test.longestNiceSubarray(nums);
        System.out.println(ans);
    }

//    public int longestNiceSubarray(int[] nums) {
//
//        int n = nums.length;
//        if (n == 1) {
//            return 1;
//        }
//        int l = 0;
//        int ans = 1;
//        int[] bitCount = new int[32];
//        for (int r = 0; r < n; r++) {
//            int currNum = nums[r];
//            int orNumber = 0;
//            for (int i = 0; i < 32; i++) {
//                if (bitCount[i] > 0) {
//                    orNumber |= (1 << i);
//                }
//            }
//            while ((currNum & orNumber) != 0) {
//                int leftEle = nums[l++];
//                for (int i = 0; i < 32; i++) {
//                    if ((leftEle & (1 << i)) > 0) {
//                        bitCount[i]--;
//                    }
//                }
//                orNumber = 0;
//                for (int i = 0; i < 32; i++) {
//                    if (bitCount[i] > 0) {
//                        orNumber |= (1 << i);
//                    }
//                }
//            }
//            for (int i = 0; i < 32; i++) {
//                if ((currNum & (1 << i)) > 0) {
//                    bitCount[i]++;
//                }
//            }
//            ans = Math.max(ans, r - l + 1);
//        }
//        return ans;
//    }

    public int longestNiceSubarray(int[] nums) {

        int n = nums.length;
        if (n == 1) {
            return 1;
        }
        int l = 0;
        int mask = 0;
        int ans = 1;
        for (int r = 0; r < n; r++) {
            int currNum = nums[r];
            while ((mask & currNum) != 0) {
                int leftElement = nums[l++];
                mask ^= leftElement;
            }
            mask |= currNum;
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
