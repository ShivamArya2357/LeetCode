package Practice.src.warmup;

public class LeetCode1325 {

    public static void main(String[] args) {


    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {

        if (root == null) {
            return null;
        } else {
            root.left = removeLeafNodes(root.left, target);
            root.right = removeLeafNodes(root.right, target);
            if (root.left == null && root.right == null && root.val == target) {
                return null;
            } else {
                return root;
            }
        }
    }

    private TreeNode remove(TreeNode root, int target) {

        if (root.left == null && root.right == null) {
            if (root.val == target) {
                return null;
            } else {
                return root;
            }
        }
        root.left = remove(root.left, target);
        root.right = remove(root.right, target);
        return root;
    }
}
