package Practice.src.warmup;

public class LeetCode100 {

    public static void main(String[] args) {

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        } else if ((p != null && q == null) || ((p == null && q != null))
                || (p.val != q.val)
        ) {
            return false;
        } else {
            boolean leftAns = isSameTree(p.left, q.left);
            boolean rightAns = isSameTree(p.right, q.right);
            return leftAns && rightAns;
        }
    }
}
