package Practice.src.warmup;

public class LeetCode1026 {

    private int ans = Integer.MIN_VALUE;

    public static void main(String[] args) {

    }

    public int maxAncestorDiff(TreeNode root) {

        maxAncestorDiff(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return ans;
    }

    public void maxAncestorDiff(TreeNode root, int maxNode, int minNode) {

        if (root != null) {
            maxNode = Math.max(maxNode, root.val);
            minNode = Math.min(minNode, root.val);
            maxAncestorDiff(root.left, maxNode, minNode);
            maxAncestorDiff(root.right, maxNode, minNode);
            ans = Math.max(ans, maxNode - minNode);
        }
    }
}
