package Practice.src.warmup;

public class LeetCode122 {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {

        int n = prices.length;
        int maxProfit = 0;
        for (int i = 0; i < n - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                maxProfit += prices[i + 1] - prices[i];
            }
        }
        return maxProfit;
    }
}
