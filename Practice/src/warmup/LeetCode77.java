package Practice.src.warmup;

import java.util.ArrayList;
import java.util.List;

public class LeetCode77 {

    List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {

        LeetCode77 test = new LeetCode77();
        List<List<Integer>> res = test.combine(10, 3);
        for (List<Integer> a : res) {
            for (Integer b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> combine(int n, int k) {

        List<Integer> temp = new ArrayList<>();
        combine(0, n, k, temp);
        return res;
    }

    private void combine(int currNum, int n, int k, List<Integer> temp) {

        if (k == 0) {
            res.add(new ArrayList<>(temp));
        } else {
            for (int i = currNum + 1; i <= n; i++) {
                temp.add(i);
                combine(i, n, k - 1, temp);
                temp.removeLast();
            }
        }
    }
}
