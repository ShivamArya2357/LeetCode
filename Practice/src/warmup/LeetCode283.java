package Practice.src.warmup;

public class LeetCode283 {

    public static void main(String[] args) {

        LeetCode283 test = new LeetCode283();
        int[] nums = new int[]{0,1,0,3,12};
        test.moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

//    public void moveZeroes(int[] nums) {
//
//        int n = nums.length;
//        int countZeroes = 0;
//        for (int i = 0; i < n; i++) {
//            if (nums[i] == 0) {
//                countZeroes++;
//            }
//        }
//        int j = 0;
//        for (int i = 0; i < n; i++) {
//            if (nums[i] != 0) {
//                nums[j++] = nums[i];
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            if (i + 1 > n - countZeroes) {
//                nums[i] = 0;
//            }
//        }
//    }

    public void moveZeroes(int[] nums) {

        int n = nums.length;
        int j = 0;
        for (int curr = 0; curr < n; curr++) {
            if (nums[curr] != 0) {
                swap(nums, curr, j);
                j++;
            }
        }
    }

    private void swap(int[] nums, int curr, int j) {

        int temp = nums[j];
        nums[j] = nums[curr];
        nums[curr] = temp;
    }
}
