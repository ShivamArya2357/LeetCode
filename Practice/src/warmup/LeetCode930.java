package Practice.src.warmup;

public class LeetCode930 {

    public static void main(String[] args) {

        LeetCode930 test = new LeetCode930();
        int[] nums = {0,0,0,0,0};
        int goal = 0;
        int ans = test.numSubarraysWithSum(nums, goal);
        System.out.println(ans);
    }

//    public int numSubarraysWithSum(int[] nums, int goal) {
//
//        int n = nums.length;
//        int sum = 0;
//        int start = 0;
//        int ans = 0;
//        if (goal == 0) {
//            int count = 0;
//            for (int i = 0; i < n; i++) {
//                if (nums[i] == 0) {
//                    count++;
//                } else {
//                    ans += (count * (count + 1)) / 2;
//                    count = 0;
//                }
//            }
//            ans += (count * (count + 1)) / 2;
//        } else {
//            for (int i = 0; i < n;) {
//                sum += nums[i];
//                if (sum == goal) {
//                    i++;
//                    int tempAns = 0;
//                    while (i < n && nums[i] == 0) {
//                        i++;
//                        tempAns++;
//                    }
//                    ans += 1 + tempAns;
//                    if (nums[start] == 1) {
//                        sum--;
//                        start++;
//                    } else {
//                        start++;
//                        while (start < n && nums[start] == 0) {
//                            ans += 1 + tempAns;
//                            start++;
//                        }
//                        if (start < n) {
//                            ans += 1 + tempAns;
//                            sum--;
//                            start++;
//                        }
//                    }
//                } else {
//                    i++;
//                }
//            }
//        }
//        return ans;
//    }

    public int numSubarraysWithSum(int[] nums, int goal) {

        int n = nums.length;
        int sum = 0;
        int left = 0;
        int ans = 0;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum > goal) {
                sum -= nums[left];
                left++;
            }
            ans += 0;
        }
        return ans;
    }
}
