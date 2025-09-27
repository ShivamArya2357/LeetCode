package Practice.src.warmup;

import java.util.Arrays;

public class LeetCode2358 {

    public static void main(String[] args) {

        LeetCode2358 test = new LeetCode2358();
        int[] grades = {8, 8};
        int ans = test.maximumGroups(grades);
        System.out.println(ans);
    }

    public int maximumGroups(int[] grades) {

//        Arrays.sort(grades);
        int n = grades.length;
        int l = 1;
        int h = n;
        int size = maxGroupSize(grades, n);
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (size >= mid) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return h;
    }

    private int maxGroupSize(int[] grades, int n) {

        int prevSum = grades[0];
        int prevCount = 1;
        int sum = 0;
        int count = 0;
        int size = 1;
        for (int i = 1; i < n; i++) {
            sum += grades[i];
            count++;
            if (sum > prevSum && count > prevCount) {
                prevSum = sum;
                prevCount = count;
                sum = 0;
                count = 0;
                size++;
            }
        }
        return size;
    }
}
