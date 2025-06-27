package Practice.src.warmup;

public class LeetCode75 {

    public static void main(String[] args) {

        int[] nums = new int[]{1,0,2,0,1,1,0,2,0,0};
        sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void sortColors(int[] nums) {

        int len = nums.length;
        int redColourObjectIndex = 0;
        int blueColourObjectIndex = len - 1;
        int currentIndex = 0;
        while (currentIndex <= blueColourObjectIndex) {
            if (nums[currentIndex] == 0) {
                swap(nums, redColourObjectIndex, currentIndex);
                redColourObjectIndex++;
                currentIndex++;
            } else if (nums[currentIndex] == 2) {
                swap(nums, blueColourObjectIndex, currentIndex);
                blueColourObjectIndex--;
            } else {
                currentIndex++;
            }
        }
    }

    private static void swap(int[] nums, int redColourObjectIndex, int currentIndex) {

        int temp = nums[redColourObjectIndex];
        nums[redColourObjectIndex] = nums[currentIndex];
        nums[currentIndex] = temp;
    }
}
