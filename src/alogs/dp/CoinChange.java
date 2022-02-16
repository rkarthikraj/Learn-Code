package alogs.dp;

import java.util.Arrays;

class CoinChange {
    public static void main(String[] args) {
        CoinChange obj = new CoinChange();
        int[] coins = {1, 2, 5};
        int amount = 11;

        System.out.println(obj.coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        if (coins.length <= 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return (dp[amount] == (amount + 1)) ? -1 : dp[amount];
    }
}