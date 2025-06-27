package Practice.src.warmup;

public class LeetCode654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        int n = nums.length;
        return prepareMaxBinaryTree(nums, 0, n - 1);
    }

    private TreeNode prepareMaxBinaryTree(int[] nums, int l, int r) {

        if (l > r) {
            return null;
        }
        int maxNum = Integer.MIN_VALUE;
        int maxNumIndex = 0;
        for (int i = l; i <= r; i++) {
           if (maxNum < nums[i]) {
               maxNum = nums[i];
               maxNumIndex = i;
           }
        }
        TreeNode leftNode = prepareMaxBinaryTree(nums, l, maxNumIndex - 1);
        TreeNode rightNode = prepareMaxBinaryTree(nums, maxNumIndex + 1, r);
        return new TreeNode(maxNum, leftNode, rightNode);
    }
}
