package Practice.src.warmup;

public class LeetCode222 {

    public static void main(String[] args) {

    }

    public int countNodes(TreeNode root) {

        int h = height(root);
        int l = 0;
        int r = (1 << h) - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (exist(mid, h, root)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ((1 << h) - 1) + l;
    }

    private boolean exist(int index, int h, TreeNode root) {

        int l = 0;
        int r = (1 << h) - 1;
        for (int i = 0; i < h; i++) {
            int mid = l + (r - l) / 2;
            if (index <= mid) {
                root = root.left;
                r = mid;
            } else {
                root = root.right;
                l = mid + 1;
            }
        }
        return (root != null);
    }

    private int height(TreeNode root) {

        int height = 0;
        while (root.left != null) {
            root = root.left;
            height++;
        }
        return height;
    }
}
