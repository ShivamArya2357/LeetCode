package Practice.src.warmup;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1557 {

    public static void main(String[] args) {

    }

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

        boolean[] incomingEdgesCount = new boolean[n];
        for (List<Integer> edge : edges) {
            int src = edge.get(0);
            int dest = edge.get(1);
            incomingEdgesCount[dest] = true;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!incomingEdgesCount[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
}
