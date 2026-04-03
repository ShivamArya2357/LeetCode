package Practice.src.warmup;

public class LeetCode1966 {

    public static void main(String[] args) {

    }

    public int binarySearchable(int[] arr, int n) {

        int[] minArr = new int[n];
        minArr[n - 1] = Integer.MAX_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            minArr[i] = Math.min(arr[i + 1], minArr[i + 1]);
        }
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max && arr[i] < minArr[i]) {
                count++;
            }
            max = Math.max(max, arr[i]);
        }
        return count;
    }
}
