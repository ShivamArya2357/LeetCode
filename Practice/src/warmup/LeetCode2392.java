package Practice.src.warmup;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode2392 {

    public static void main(String[] args) {

        int k = 3;
        int[][] rowConditions = new int[][]{
                {1,2},{2,3},{3,1},{2,3}
        };
        int[][] colConditions = new int[][]{
                {2, 1}
        };

        int[][] res = buildMatrix(k, rowConditions, colConditions);

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {

        List<List<Integer> > adjList1 = createGraph(k, rowConditions);
        List<List<Integer> > adjList2 = createGraph(k, colConditions);
        List<Integer> topologicalSort1 = topologicalSort(k, adjList1);
        List<Integer> topologicalSort2 = topologicalSort(k, adjList2);
        if (topologicalSort1.size() != k || topologicalSort2.size() != k) {
            return new int[][]{};
        } else {
            int[][] res = new int[k][k];
            int[] col = new int[k];
            for (int i = 0; i < topologicalSort2.size(); i++) {
                col[topologicalSort2.get(i)] = i;
            }
            int row = 0;
            for (int i = 0; i < topologicalSort1.size(); i++) {
                res[row++][col[topologicalSort1.get(i)]] = topologicalSort1.get(i) + 1;
            }
            return res;
        }
    }

    private static List<List<Integer>> createGraph(int k, int[][] edges) {

        int edgeCount = edges.length;
        List<List<Integer> > adjList = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            adjList.add(new LinkedList<>());
        }
        for (int i = 0; i < edgeCount; i++) {
            addEdge(adjList, edges[i][0] - 1, edges[i][1] - 1);
        }
        return adjList;
    }

    private static void addEdge(List<List<Integer> > adjList, int src, int dest) {
        adjList.get(src).add(dest);
    }

    private static List<Integer> topologicalSort(int k, List<List<Integer> > adjList) {

        int[] inDegree = new int[k];
        for (int i = 0; i < k; i++) {
            for (int neighbour : adjList.get(i)) {
                inDegree[neighbour]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        List<Integer> topologicalSort = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topologicalSort.add(node);
            for (int neighbour : adjList.get(node)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }
        return topologicalSort;
    }
}
