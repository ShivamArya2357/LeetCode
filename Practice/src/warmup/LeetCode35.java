package Practice.src.warmup;

public class LeetCode35 {

    public static void main(String[] args) {

        LeetCode35 test = new LeetCode35();
        int index = test.searchInsert(new int[]{1,3,5,6}, 7);
        System.out.println(index);
    }

    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target);
    }

    private static int binarySearch(int[] nums, int target) {

        int l = 0;
        int h = nums.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return l;
    }
}
