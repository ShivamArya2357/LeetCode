package Practice.src.warmup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LeetCode1331 {

    public static void main(String[] args) {

        LeetCode1331 test = new LeetCode1331();
        int[] arr = {37,12,28,9,100,56,80,5,12};
        int[] ans = test.arrayRankTransform(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }

    public int[] arrayRankTransform(int[] arr) {

        int n = arr.length;
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            indices.add(i);
        }
        Collections.sort(indices, Comparator.comparingInt(idx -> arr[idx]));
        int[] ans = new int[n];
        int rank = 0;
        for (int i = 0; i < indices.size(); i++) {
            if (i - 1 >= 0 && arr[indices.get(i - 1)] == arr[indices.get(i)]) {
                ans[indices.get(i)] = rank;
            } else {
                ans[indices.get(i)] = ++rank;
            }
        }
        return ans;
    }
}
