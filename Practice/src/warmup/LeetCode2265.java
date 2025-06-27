package Practice.src.warmup;

public class LeetCode2265 {

    private int ans = 0;

    public int averageOfSubtree(TreeNode root) {

        avg(root);
        return ans;
    }

    private Pair avg(TreeNode root) {

        if (root == null) {
            return new Pair(0, 0);
        }
        Pair leftPair = avg(root.left);
        Pair rightPair = avg(root.right);
        Pair newPair = new Pair(
                leftPair.getCount() + rightPair.getCount() + 1,
                leftPair.getSum() + rightPair.getSum() + root.val
        );
        if (newPair.getSum() / newPair.getCount() == root.val) {
            ans++;
        }
        return newPair;
    }

    static class Pair {

        private int count;

        private int sum;

        public Pair(int count, int sum) {
            this.count = count;
            this.sum = sum;
        }

        public int getCount() {
            return count;
        }

        public int getSum() {
            return sum;
        }
    }
}
