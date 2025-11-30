package Practice.src.warmup;

public class LeetCode121 {

    public static void main(String[] args) {

        LeetCode121 test = new LeetCode121();
        int ans = test.maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(ans);
    }

    public int maxProfit(int[] prices) {

        int n = prices.length;
        int maxSofar = prices[n - 1];
        int maxProfit = Integer.MIN_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            maxProfit = Math.max(maxProfit, maxSofar - prices[i]);
            maxSofar = Math.max(maxSofar, prices[i]);
        }
        return Math.max(maxProfit, 0);
    }
}
