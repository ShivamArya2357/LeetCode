package Practice.src.warmup;

public class LeetCode518 {

    public static void main(String[] args) {

    }

    public int change(int amount, int[] coins) {

        Integer[][] dp = new Integer[amount + 1][coins.length];
        int ans = findDenominationCount(dp, amount, 0, coins);
        return ans;
    }

    private int findDenominationCount(Integer[][] dp, int amount, int i, int[] coins) {

        if (amount == 0) {
            return 1;
        }
        if (amount < 0 || i >= coins.length) {
            return 0;
        }
        if (dp[amount][i] != null) {
            return dp[amount][i];
        }
        return (dp[amount][i] = findDenominationCount(dp, amount, i + 1, coins) +
                findDenominationCount(dp, amount - coins[i], i, coins));
    }
}
