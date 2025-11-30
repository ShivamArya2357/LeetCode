package Practice.src.warmup;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class InversionCount {

    public static void main(String[] args) {

        int[] arr = new int[]{2,4,1,3,5};
        int ans = inversionCount(arr);
        System.out.println(ans);
    }

    public static int inversionCount(int[] arr) {

        int n = arr.length;
        int[] duplicateArr = Arrays.copyOf(arr, n);
        Arrays.sort(duplicateArr);
        Map<Integer, Integer> rank = new HashMap<>();
        for (int i = 0; i < n; i++) {
            rank.put(duplicateArr[i], i + 1);
        }

        int[] tree = new int[n + 1];
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            int rankValue = rank.get(arr[i]);
            update(tree, rankValue, 1);
            ans += get(tree, rankValue - 1);
        }
        return ans;
    }

    private static int findMaxElement(int[] arr, int n) {

        int maxEle = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxEle = Math.max(maxEle, arr[i]);
        }
        return maxEle;
    }

    public static void update(int[] tree, int index, int value) {

        while (index < tree.length) {
            tree[index] += value;
            index += index & -index;
        }
    }

    public static int get(int[] tree, int index) {

        int count = 0;
        while (index > 0) {
            count += tree[index];
            index -= index & -index;
        }
        return count;
    }
}
