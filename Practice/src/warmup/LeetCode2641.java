package Practice.src.warmup;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode2641 {

    public static void main(String[] args) {

    }

    public TreeNode replaceValueInTree(TreeNode root) {

        int height = heightOfBT(root);
        int[] sum = levelOrderTraversal(root, height);
        replaceValues(sum, root, null, 0);
        return root;
    }

    private void replaceValues(int[] sum, TreeNode currNode, TreeNode parentNode, int level) {

        if (currNode == null) {
            return;
        } else if (currNode.left != null && currNode.right != null) {
            int totalSiblingValue = currNode.left.val + currNode.right.val;
            currNode.left.val = sum[level] - totalSiblingValue;
            currNode.right.val = sum[level] - totalSiblingValue;
        } else if (currNode.left != null) {
            int totalSiblingValue = currNode.left.val;
            currNode.left.val = sum[level] - totalSiblingValue;
        } else if (currNode.right != null) {
            int totalSiblingValue = currNode.right.val;
            currNode.right.val = sum[level] - totalSiblingValue;
        } else {
            replaceValues(sum, currNode.left, currNode, level + 1);
            replaceValues(sum, currNode.right, currNode, level + 1);
        }
    }

    private int heightOfBT(TreeNode root) {

        if (root == null) {
            return 0;
        }
        return 1 + Math.max(heightOfBT(root.left), heightOfBT(root.right));
    }

    private int[] levelOrderTraversal(TreeNode root, int height) {

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        int[] sum = new int[height + 1];
        root.val = 0;
        while (!queue.isEmpty()) {
            Pair front = queue.poll();
            TreeNode currNode = front.getNode();
            int currLevel = front.getLevel();
            sum[currLevel] += currNode.val;
            if (currNode.left != null) {
                queue.add(new Pair(currNode.left, currLevel + 1));
            }
            if (currNode.right != null) {
                queue.add(new Pair(currNode.right, currLevel + 1));
            }
        }
        return sum;
    }

    static class Pair {

        private TreeNode node;

        private int level;

        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }

        public TreeNode getNode() {
            return node;
        }

        public int getLevel() {
            return level;
        }
    }
}
