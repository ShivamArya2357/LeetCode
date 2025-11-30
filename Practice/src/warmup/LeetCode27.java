package Practice.src.warmup;

public class LeetCode27 {

    public static void main(String[] args) {

        LeetCode27 test = new LeetCode27();
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int length = test.removeElement(nums, 2);
        System.out.println(length);
    }

    public int removeElement(int[] nums, int val) {

        int n = nums.length;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                nums[index++] = val;
            }
        }
        return index;
    }
}
