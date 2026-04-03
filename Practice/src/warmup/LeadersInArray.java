package Practice.src.warmup;

import java.util.ArrayList;
import java.util.List;

public class LeadersInArray {

    public static void main(String[] args) {

    }

    public int[] solve(int[] A) {

        int n = A.length;
        List<Integer> result = new ArrayList<>();
        result.add(A[n - 1]);
        int maxElement = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] > maxElement) {
                result.add(A[i]);
                maxElement = Math.max(maxElement, A[i]);
            }
        }
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}
