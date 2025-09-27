package Practice.src.warmup;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode872 {

    public static void main(String[] args) {

    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> leafNodes1 = new ArrayList<>();
        dfs(root1, leafNodes1);
        List<Integer> leafNodes2 = new ArrayList<>();
        dfs(root2, leafNodes2);
        for (Integer node: leafNodes1) {
            System.out.print(node + " ");
        }
        System.out.println();
        for (Integer node: leafNodes2) {
            System.out.print(node + " ");
        }
        System.out.println();
        if (leafNodes1.size() == leafNodes2.size()) {
            return leafNodes1.equals(leafNodes2);
        }
        return false;
    }

    private void dfs(TreeNode root, List<Integer> leafNodes) {

        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            leafNodes.add(root.val);
        } else {
            dfs(root.left, leafNodes);
            dfs(root.right, leafNodes);
        }
    }
}
