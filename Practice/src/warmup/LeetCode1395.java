package Practice.src.warmup;

import java.util.Arrays;
import java.util.Collections;

public class LeetCode1395 {

    public static void main(String[] args) {

        LeetCode1395 test = new LeetCode1395();
        int[] rating = {1,2,3,4};
        int ans = test.numTeams(rating);
        System.out.println(ans);
    }

    public int numTeams(int[] rating) {

        int[] count1 = countGreaterNums(rating);
        int[] reversedRating = new int[rating.length];
        for (int i = 0; i < rating.length; i++) {
            reversedRating[rating.length - i - 1] = rating[i];
        }
        int[] count2 = countGreaterNums(reversedRating);
        int ans = calculateTotal(count1, rating);
        ans += calculateTotal(count2, reversedRating);
        return ans;
    }

    private int calculateTotal(int[] count, int[] rating) {

        int n = count.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (rating[i] < rating[j]) {
                    ans += count[j];
                }
            }
        }
        return ans;
    }

    private int[] countGreaterNums(int[] rating) {

        int n = rating.length;
        int[] count1 = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                if (rating[i] < rating[j]) {
                    count++;
                }
            }
            count1[i] = count;
        }
        return count1;
    }
}
