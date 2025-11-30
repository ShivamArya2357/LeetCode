package Practice.src.warmup;

import java.util.ArrayList;
import java.util.List;

public class LeetCode101 {

    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {

        return isSymmetric(root, root);
    }

    private boolean isSymmetric(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) {
            return true;
        }
        if ((root1 == null || root2 == null) || root1.val != root2.val) {
            return false;
        } else {
            if (!isSymmetric(root1.left, root2.right)) {
                return false;
            }
            if (!isSymmetric(root1.right, root2.left)) {
                return false;
            }
            return true;
        }
    }
}
