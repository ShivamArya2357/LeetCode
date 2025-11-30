package Practice.src.contest.Contest1;

import java.util.Arrays;

public class Q2 {

    public static void main(String[] args) {

        Q2 test = new Q2();
        int[] arr = new int[]{-2,1,-5,4,-3,-6};
        int[] brr = new int[]{5,2,0,-1,-2,-10};
        long k = 2;
        long ans = test.minCost(arr, brr, k);
        System.out.println(ans);
    }

    public long minCost(int[] arr, int[] brr, long k) {

        long finalAns = 0;
        int n = arr.length;
        if (!isArrSortedInInc(arr, n) && !isArrSortedInDec(arr, n)) {
            long ans1 = k;
            Arrays.sort(arr);
            Arrays.sort(brr);
            for (int i = 0; i < n; i++) {
                ans1 += Math.abs(arr[i] - brr[i]);
            }
            long ans2 = k;
            reverseSort(arr, n);
            reverseSort(brr, n);
            for (int i = 0; i < n; i++) {
                ans2 += Math.abs(arr[i] - brr[i]);
            }
            return Math.min(ans1, ans2);
        } else if (isArrSortedInInc(arr, n)) {
            Arrays.sort(brr);
            long ans1 = 0;
            for (int i = 0; i < n; i++) {
                ans1 += Math.abs(arr[i] - brr[i]);
            }
            long ans2 = 0;
            reverseSort(brr, n);
            for (int i = 0; i < n; i++) {
                ans2 += Math.abs(arr[i] - brr[i]);
            }
            return Math.min(ans1, ans2);
        } else if (isArrSortedInDec(arr, n)) {
            long ans1 = 0;
            reverseSort(brr, n);
            for (int i = 0; i < n; i++) {
                ans1 += Math.abs(arr[i] - brr[i]);
            }

            Arrays.sort(brr);
            long ans2 = 0;
            for (int i = 0; i < n; i++) {
                ans2 += Math.abs(arr[i] - brr[i]);
            }
            return Math.min(ans1, ans2);
        }
        return 0;
    }

    private void reverseSort(int[] brr, int n) {

        Arrays.sort(brr);
        int l = 0;
        int h = n - 1;
        while (l < h) {
            int temp = brr[l];
            brr[l] = brr[h];
            brr[h] = temp;
            l++;
            h--;
        }
    }

    private boolean isArrSortedInDec(int[] arr, int n) {

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private boolean isArrSortedInInc(int[] arr, int n) {

        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
