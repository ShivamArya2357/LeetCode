package Practice.src.warmup;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1382 {

    public static void main(String[] args) {

    }

    public TreeNode balanceBST(TreeNode root) {

        List<Integer> nodeValues = new ArrayList<>();
        inOrderTraversal(root, nodeValues);
        return buildBalancedBST(nodeValues, 0, nodeValues.size() - 1);
    }

    private TreeNode buildBalancedBST(List<Integer> nodeValues, int l, int h) {

        if (l > h) {
            return null;
        }

        int mid = l + (h - l) / 2;
        TreeNode node = new TreeNode(nodeValues.get(mid));
        node.left = buildBalancedBST(nodeValues, l, mid - 1);
        node.right = buildBalancedBST(nodeValues, mid + 1, h);
        return node;
    }

    private void inOrderTraversal(TreeNode root, List<Integer> nodeValues) {

        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, nodeValues);
        nodeValues.add(root.val);
        inOrderTraversal(root.right, nodeValues);
    }
}
