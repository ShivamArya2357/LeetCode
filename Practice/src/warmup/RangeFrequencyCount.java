package Practice.src.warmup;

public class RangeFrequencyCount {

    public static void main(String[] args) {

        int[] arr = new int[]{12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56};
        int ans = calculateFrequencyCountInRange(arr, 1, 2, 4);
        System.out.println(ans);
    }

    public static int calculateFrequencyCountInRange(int[] arr, int l, int r, int x) {

        int n = arr.length;
        int[][] tree = new int[100001][n + 1];
        for (int i = 0; i < n; i++) {
            update(n, tree, arr[i],  i + 1, 1);
        }
        return get(tree, x, r) - get(tree, x, l - 1);
    }

    private static void update(int n, int[][] tree, int value, int pos, int delta) {

        while (pos <= n) {
            tree[value][pos] += delta;
            pos += pos & -pos;
        }
    }

    private static int get(int[][] tree, int value, int pos) {

        int count = 0;
        while (pos > 0) {
            count += tree[value][pos];
            pos -= pos & -pos;
        }
        return count;
    }
}
