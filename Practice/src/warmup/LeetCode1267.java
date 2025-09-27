package Practice.src.warmup;

public class LeetCode1267 {

    static class UF {

        int[] group, r;

        public UF(int n) {
            this.group = new int[n];
            this.r = new int[n];
            for (int i = 0; i < n; i++) {
                group[i] = i;
            }
        }

        public int find(int x) {
            if (group[x] == x) {
                return x;
            }
            return find(group[x]);
        }

        public void union(int x, int y) {

            int groupLead1 = find(x);
            int groupLead2 = find(y);
            if (groupLead1 == groupLead2) {
            } else if (r[groupLead1] < r[groupLead2]) {
                group[groupLead1] = groupLead2;
            } else if (r[groupLead1] > r[groupLead2]) {
                group[groupLead2] = groupLead1;
            } else {
                group[groupLead2] = groupLead1;
                r[groupLead1]++;
            }
        }
    }

    public static void main(String[] args) {

    }

    public int countServers(int[][] grid) {

        int R = grid.length;
        int C = grid[0].length;
        int[] edgeCount = new int[R + C];
        UF uf = new UF(R + C);

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 1) {
                    uf.union(i, R + j);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 1) {
                    int root = uf.find(i);
                    edgeCount[root]++;
                }
            }
        }
        for (int i = 0; i < R + C; i++) {
            if (edgeCount[i] > 1) {
                ans += edgeCount[i];
            }
        }
        return ans;
    }
}
