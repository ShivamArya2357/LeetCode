package Practice.src.warmup;

import java.util.Stack;

public class TheCelebrityProblem {

    public static void main(String[] args) {

        TheCelebrityProblem test = new TheCelebrityProblem();
        int mat[][] = new int[][]{
                {0, 1, 0},
                {0, 0, 0},
                {0, 1, 0}
        };
        int ans = test.celebrity2(mat);
        System.out.println(ans);
    }

    public int celebrity(int mat[][]) {

        int n = mat.length;
        int[] out = new int[n];
        int[] in = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && mat[i][j] == 1) {
                    out[i]++;
                    in[j]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (out[i] == 0 && in[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }

    public int celebrity2(int mat[][]) {

        Stack<Integer> candidates = new Stack<>();
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            candidates.add(i);
        }
        while (candidates.size() > 1) {
            int a = candidates.pop();
            int b = candidates.pop();
            if (mat[a][b] != 0) {
                candidates.add(b);
            } else {
                candidates.add(a);
            }
        }
        int candidate = candidates.pop();
        for (int i = 0; i < n; i++) {
            if (i != candidate && (mat[i][candidate] == 0 || mat[candidate][i] != 0)) {
                return -1;
            }
        }
        return candidate;
    }

    public int celebrity3(int mat[][]) {

        int n = mat.length;
        int i = 0;
        int j = n;
        while (i < j) {
            if (mat[i][j] != 0) {
                i++;
            } else {
                j--;
            }
        }
        int candidate = i;
        for (int k = 0; k < n; k++) {
            if (k != candidate && (mat[k][candidate] == 0 || mat[candidate][k] != 0)) {
                return -1;
            }
        }
        return candidate;
    }
}
