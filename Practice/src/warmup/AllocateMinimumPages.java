package Practice.src.warmup;

import java.util.Arrays;

public class AllocateMinimumPages {

    public static void main(String[] args) {

        AllocateMinimumPages test = new AllocateMinimumPages();
        int[] arr = {15, 10, 19, 10, 5, 18, 7};
        int k = 5;
        int ans = test.findPages(arr, k);
        System.out.println(ans);
    }

    public int findPages(int[] arr, int k) {

        if (arr.length < k) {
            return -1;
        }
        int l = Arrays.stream(arr).max().getAsInt();
        int sum = Arrays.stream(arr).sum();
        int h = sum;
        int ans = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (isPossible(arr, k, mid)) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] arr, int k, int X) {

        int count = 0;
        int currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (currSum > X || arr[i] > X) {
                return false;
            } else if (currSum + arr[i] <= X) {
                currSum += arr[i];
            } else {
                currSum = arr[i];
                count++;
            }
        }
        return (count + 1) <= k;
    }
}
