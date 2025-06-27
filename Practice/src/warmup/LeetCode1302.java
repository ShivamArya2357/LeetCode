package Practice.src.warmup;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LeetCode1302 {

    Map<Integer, Integer> levelWiseSumMap = new HashMap<>();
    int maxLevel = 0;

    public static void main(String[] args) {

    }

    public int deepestLeavesSum(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelSum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            levelSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                levelSum += currNode.val;
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
        }
        return levelSum;
    }

//    public int deepestLeavesSum(TreeNode root) {
//
//        deepestSum(root, 0);
//        return levelWiseSumMap.get(maxLevel);
//    }
//
//    public void deepestSum(TreeNode root, int level) {
//
//        if (root == null) {
//            return;
//        }
//        levelWiseSumMap.put(level, levelWiseSumMap.getOrDefault(level, 0) + root.val);
//        maxLevel = Math.max(maxLevel, level);
//        deepestSum(root.left, level + 1);
//        deepestSum(root.right, level + 1);
//    }
}
