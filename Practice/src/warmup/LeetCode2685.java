package Practice.src.warmup;

import java.util.*;

public class LeetCode2685 {

    public static void main(String[] args) {

    }

    public int countCompleteComponents(int n, int[][] edges) {

        DSU dsu = new DSU(n);
        for (int i = 0; i < edges.length; i++) {
            dsu.union(edges[i][0], edges[i][1]);
        }
        Map<Integer, Integer> edgeCountMap = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int parent = dsu.find(edges[i][0]);
            edgeCountMap.put(parent, edgeCountMap.getOrDefault(parent, 0) + 1);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dsu.find(i) == i) {
                int nodeCount = dsu.size[i];
                int expectedEdges = (nodeCount * (nodeCount - 1)) / 2;
                if (edgeCountMap.getOrDefault(i, 0) == expectedEdges) {
                    ans++;
                }
            }
        }
        return ans;
    }

    class DSU {

        private int[] parent;

        private int[] size;

        public DSU(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            Arrays.fill(parent, -1);
            Arrays.fill(size, 1);
        }

        private int find(int node) {

            if (parent[node] == -1) {
                return node;
            } else {
                return parent[node] = find(parent[node]);
            }
        }

        private void union(int node1, int node2) {

            int parent1 = find(node1);
            int parent2 = find(node2);
            if (parent1 == parent2) {
                return;
            } else {
                if (size[parent1] > size[parent2]) {
                    parent[parent2] = parent1;
                    size[parent1] += size[parent2];
                } else {
                    parent[parent1] = parent2;
                    size[parent2] += size[parent1];
                }
            }
        }
    }
}
