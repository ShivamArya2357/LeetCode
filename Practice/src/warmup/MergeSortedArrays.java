package Practice.src.warmup;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MergeSortedArrays {

    public static void main(String[] args) {

        MergeSortedArrays test = new MergeSortedArrays();
        int[][] A = { {1, 3}, {2, 6}, {8, 10}, {15, 18} };
        int[][] res = test.solve(A);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i][0] + " " + res[i][1]);
        }
    }

    public int[][] solve(int[][] A) {

        int n = A.length;
        List<int[]> res = new ArrayList<>();
        Stack<int[]> stack = new Stack<>();
        stack.add(A[0]);
        for (int i = 1; i < n; i++) {
            int[] top = stack.peek();
            int[] curr = A[i];
            if (isOverlap(top, curr)) {
                stack.pop();
                stack.add(new int[]{top[0], Math.max(top[1], curr[1])});
            } else {
                stack.add(curr);
            }
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return reverse(res).toArray(new int[res.size()][2]);
    }

    private List<int[]> reverse(List<int[]> res) {

        List<int[]> reversedList = new ArrayList<>();
        for (int i = res.size() - 1; i >= 0; i--) {
            reversedList.add(res.get(i));
        }
        return reversedList;
    }

    private boolean isOverlap(int[] top, int[] curr) {
        return curr[0] >= top[0] && curr[0] <= top[1];
    }
}
