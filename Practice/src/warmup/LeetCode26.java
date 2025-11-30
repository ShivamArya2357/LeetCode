package Practice.src.warmup;

public class LeetCode26 {

    public int removeDuplicates(int[] nums) {

        int n = nums.length;
        int index = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
