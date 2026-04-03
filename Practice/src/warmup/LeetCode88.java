package Practice.src.warmup;

public class LeetCode88 {

    public static void main(String[] args) {

        LeetCode88 test = new LeetCode88();
        int[] nums1 = {10,13,15,0,0,0};
        int[] nums2 = {3,14,20};
        int m = 3;
        int n = 3;
        test.merge(nums1, m, nums2, n);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println();
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int j = m - 1;
        int k = n - 1;
        int i = m + n - 1;
        while (j >= 0 && k >= 0) {
            if (j >= 0 && k >= 0 && nums1[j] > nums2[k]) {
                nums1[i--] = nums1[j--];
            } else if (j >= 0 && k >= 0 && nums1[j] <= nums2[k]) {
                nums1[i--] = nums2[k--];
            }
        }
        while (j >= 0) {
            nums1[i--] = nums1[j--];
        }
        while (k >= 0) {
            nums1[i--] = nums2[k--];
        }
    }
}
