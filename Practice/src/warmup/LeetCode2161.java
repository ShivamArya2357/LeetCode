package Practice.src.warmup;

public class LeetCode2161 {

    public static void main(String[] args) {

        LeetCode2161 test = new LeetCode2161();
        int[] nums = new int[]{9,12,5,10,14,3,10};
        int[] ans = test.pivotArray(nums, 10);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }

    public int[] pivotArray(int[] nums, int pivot) {

        int n = nums.length;
        int[] newArr = new int[n];
        int count = 0;
        int equalOccurrence = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < pivot) {
                newArr[count++] = nums[i];
            } else if (nums[i] == pivot) {
                equalOccurrence++;
            }
        }
        while (equalOccurrence > 0) {
            newArr[count++] = pivot;
            equalOccurrence--;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > pivot) {
                newArr[count++] = nums[i];
            }
        }
        return newArr;
    }
}
