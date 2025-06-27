package Practice.src.warmup;

import java.util.*;

public class LeetCode2415 {

    public TreeNode reverseOddLevels(TreeNode root) {

        reverse(root.left, root.right, 1);
        return root;
    }

    private void reverse(TreeNode left, TreeNode right, int level) {

        if (left == null || right == null) {
            return;
        } else {
            if (level % 2 == 1) {
                int temp = left.val;
                left.val = right.val;
                right.val = temp;
            }
            reverse(left.left, right.right, level + 1);
            reverse(left.right, right.left, level + 1);
        }
    }
}
