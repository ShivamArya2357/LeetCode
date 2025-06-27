package Practice.src.warmup;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1409 {

    public static void main(String[] args) {

    }

//    public int[] processQueries(int[] queries, int m) {
//
//        int[] res = new int[queries.length];
//        List<Integer> permutation = new LinkedList<>();
//        for (int i = 1; i <= m; i++) {
//            permutation.add(i);
//        }
//        int count = 0;
//        for (int query : queries) {
//            int index = permutation.indexOf(query);
//            res[count++] = index;
//            permutation.remove(index);
//            permutation.addFirst(query);
//        }
//        return res;
//    }

    public int[] processQueries(int[] queries, int m) {

        int n = queries.length;
        int size = m + n;
        int[] tree = new int[size + 1];
        Map<Integer, Integer> positionsMap = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            positionsMap.put(i, n + i);
            update(tree, n + i, 1);
        }
        int[] res = new int[n];
        int currentPosition = n;
        for (int i = 0; i < n; i++) {
            int query = queries[i];
            int pos = positionsMap.get(query);
            res[i] = query(tree, pos) - 1;
            update(tree, pos, -1);
            positionsMap.put(query, currentPosition);
            update(tree, currentPosition, 1);
            currentPosition--;
        }
        return res;
    }

    public void update(int[] tree, int index, int delta) {

        while (index < tree.length) {
            tree[index] += delta;
            index += index & -index;
        }
    }

    public int query(int[] tree, int index) {

        int sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= index & -index;
        }
        return sum;
    }
}
