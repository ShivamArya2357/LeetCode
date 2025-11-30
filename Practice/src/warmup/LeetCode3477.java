package Practice.src.warmup;

import java.util.Arrays;
import java.util.Map;

public class LeetCode3477 {

    public static void main(String[] args) {

    }

//    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
//
//        int ans = 0;
//        for (int i = 0; i < fruits.length; i++) {
//            int quantity = fruits[i];
//            int j;
//            for (j = 0; j < baskets.length; j++) {
//                if (baskets[j] >= quantity) {
//                    baskets[j] = 0;
//                    break;
//                }
//            }
//            if (j == baskets.length) {
//                ans++;
//            }
//        }
//        return ans;
//    }

    static class SegTree {

        private int n;

        private int[] tree;

        private int[] arr;

        public SegTree(int[] arr) {
            this.n = arr.length;
            this.tree = new int[4 * n];
            this.arr = Arrays.copyOf(arr, n);
            build(1, 0, n - 1);
        }

        private void build(int p, int l, int r) {

            if (l == r) {
                tree[p] = arr[l];
            } else {
                int mid = (l + r) >> 1;
                build((p << 1), l, mid);
                build((p << 1) | 1, mid + 1, r);
                tree[p] = Math.max(tree[p << 1], tree[p << 1 | 1]);
            }
        }

        public int query(int ql, int qr) {

            return query(1, 0, n - 1, ql, qr);
        }

        private int query(int p, int l, int r, int ql, int qr) {

            if (qr < l || ql > r) {
                return Integer.MIN_VALUE;
            }
            if (ql <= l && qr >= r) {
                return tree[p];
            }
            int mid = (l + r) >> 1;
            return Math.max(query((p << 1), l, mid, ql, qr),
                    query((p << 1) | 1, mid + 1, r, ql, qr)
            );
        }

        public void update(int pos, int val) { update(1, 0, n - 1, pos, val); }

        private void update(int p, int L, int R, int pos, int val) {

            if (L == R) { tree[p] = val; return; }
            int mid = (L + R) >>> 1;
            if (pos <= mid) update(p << 1, L, mid, pos, val);
            else            update(p << 1 | 1, mid + 1, R, pos, val);
            tree[p] = Math.max(tree[p << 1], tree[p << 1 | 1]);
        }
    }

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {

        int n = baskets.length;
        SegTree segTree = new SegTree(baskets);
        int ans = 0;
        for (int fruit : fruits) {
            int l = 0;
            int h = n - 1;
            int res = -1;
            while (l <= h) {
                int mid = l + (h - l) / 2;
                if (segTree.query(0, mid) >= fruit) {
                    res = mid;
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            if (res == -1) {
                ans++;
            } else {
                segTree.update(res, Integer.MIN_VALUE);
            }
        }
        return ans;
    }
}
