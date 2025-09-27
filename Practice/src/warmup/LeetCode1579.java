package Practice.src.warmup;

public class LeetCode1579 {

    static class DSU {

        private int[] parent;
        private int[] rank;
        private int compos;

        public DSU(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            compos = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {

            if (parent[x] == x) {
                return x;
            }
            return find(parent[x]);
        }

        public boolean union(int x, int y) {

            int parent1 = find(x);
            int parent2 = find(y);
            if (parent1 == parent2) {
                return false;
            } else if (rank[parent1] < rank[parent2]) {
                parent[parent1] = parent2;
            } else if (rank[parent1] > rank[parent2]) {
                parent[parent2] = parent1;
            } else {
                parent[parent1] = parent2;
                rank[parent2]++;
            }
            compos--;
            return true;
        }
    }

    public static void main(String[] args) {

    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {

        DSU dsu1 = new DSU(n);
        DSU dsu2 = new DSU(n);
        int usedEdges = 0;
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (dsu1.union(edge[1], edge[2])) {
                    dsu2.union(edge[1], edge[2]);
                    usedEdges++;
                }
            }
        }
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (dsu1.union(edge[1], edge[2])) {
                    dsu1.union(edge[1], edge[2]);
                    usedEdges++;
                }
            }
        }
        for (int[] edge : edges) {
            if (edge[0] == 2) {
                if (dsu2.union(edge[1], edge[2])) {
                    dsu2.union(edge[1], edge[2]);
                    usedEdges++;
                }
            }
        }
        if (dsu1.compos != 1 || dsu2.compos != 1) {
            return -1;
        } else {
            return edges.length - usedEdges;
        }
    }
}
