package Practice.src.warmup;

public class LeetCode33 {

    public static void main(String[] args) {

        LeetCode33 test = new LeetCode33();
        int[] nums = new int[]{1,0,1,1,1};
        int target = 0;
//        int target = 13;
        int index = test.search2(nums, target);
        System.out.println(index);
    }

    public int search2(int[] nums, int target) {

        int l = 0;
        int h = nums.length - 1;
        int index = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[l] <= nums[mid]) {
                if (target >= nums[l] && target <= nums[mid]) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else if (nums[mid] <= nums[h]) {
                if (target >= nums[mid] && target <= nums[h]) {
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            }
        }
        return index;
    }

    public int search(int[] nums, int target) {

        int pivotIndex = getPivot(nums);
        int index1 = binarySearch(nums, target, 0, pivotIndex);
        if (index1 != -1) {
            return index1;
        }
        int index2 = binarySearch(nums, target, pivotIndex + 1, nums.length - 1);
        if (index2 != -1) {
            return index2;
        }
        return -1;
    }

    private int binarySearch(int[] nums, int target, int l, int h) {

        int index = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                h = mid - 1;
            } else {
                index = mid;
                break;
            }
        }
        return index;
    }

    public int getPivot(int[] nums) {

        int n = nums.length;
        int l = 0;
        int h = n - 1;
        int pivotIndex = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[0] <= nums[mid]) {
                pivotIndex = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return pivotIndex;
    }
}
