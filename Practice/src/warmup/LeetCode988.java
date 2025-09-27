package Practice.src.warmup;

import java.util.*;

public class LeetCode988 {

    public static void main(String[] args) {

        LeetCode988 test = new LeetCode988();
    }

    public String smallestFromLeaf(TreeNode root) {

        Map<TreeNode, TreeNode> childToParentMap = new HashMap<>();
        List<TreeNode> leafNodes = new ArrayList<>();
        preorder(root, childToParentMap, leafNodes);
        StringBuilder sb = new StringBuilder();
        while (!leafNodes.isEmpty()) {
            TreeNode smallestCharNode = findSmallestChar(leafNodes);
            sb.append((char) (smallestCharNode.val + 'a'));
            List<TreeNode> temp = new ArrayList<>();
            for (TreeNode leafNode : leafNodes) {
                if (leafNode.val == smallestCharNode.val) {
                    if (childToParentMap.containsKey(leafNode)) {
                        temp.add(childToParentMap.get(leafNode));
                    } else {
                        return sb.toString();
                    }
                }
            }
            leafNodes = new ArrayList<>(temp);
        }
        return sb.toString();
    }

    private TreeNode findSmallestChar(List<TreeNode> leafNodes) {

        int smallestChar = Integer.MAX_VALUE;
        TreeNode smallestCharNode = null;
        for (TreeNode leafNode : leafNodes) {
            if (smallestChar > leafNode.val) {
                smallestChar = leafNode.val;
                smallestCharNode = leafNode;
            }
        }
        return smallestCharNode;
    }

    private void preorder(TreeNode root, Map<TreeNode, TreeNode> childToParentMap, List<TreeNode> leafNodes) {

        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            leafNodes.add(root);
            return;
        } else {
            if (root.left != null) {
                childToParentMap.put(root.left, root);
            }
            if (root.right != null) {
                childToParentMap.put(root.right, root);
            }
            preorder(root.left, childToParentMap, leafNodes);
            preorder(root.right, childToParentMap, leafNodes);
        }
    }
}
