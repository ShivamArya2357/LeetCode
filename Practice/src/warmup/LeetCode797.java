package Practice.src.warmup;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode797 {

    List<List<Integer> > allPaths = new LinkedList<>();

    public List<List<Integer> > allPathsSourceTarget(int[][] graph) {

        int n = graph.length;
        List<Integer> path = new LinkedList<>();
        path.add(0);
        allPaths(0, path, graph, n);
        return allPaths;
    }

    private boolean allPaths(int currNode, List<Integer> path, int[][] graph, int n) {

        if (currNode == (n - 1)) {
            return true;
        }
        for (int neighbour : graph[currNode]) {
            path.add(neighbour);
            if (allPaths(neighbour, path, graph, n)) {
                allPaths.add(new ArrayList<>(path));
            }
            path.removeLast();
        }
        return false;
    }
}
