package Practice.src.warmup;

public class LeetCode3254 {

    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3,4,3,2,5};
        int[] res = resultsArray(nums, 3);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

    public static int[] resultsArray(int[] nums, int k) {

        int len = nums.length;
        if (k == 1) return nums;
        int size = len - k + 1;
        int[] res = new int[size];
        int ascendingSubArraySize = 1;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] == nums[i + 1] - 1) {
                ascendingSubArraySize++;
            } else {
                ascendingSubArraySize = 1;
            }
            if (i <= len - k) {
                size--;
                if (ascendingSubArraySize >= k) {
                    res[size] = nums[i + k - 1];
                } else {
                    res[size] = -1;
                }
            }
        }
        return res;
    }
}
