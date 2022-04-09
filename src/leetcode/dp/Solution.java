package leetcode.dp;

import java.util.Arrays;

class TribonacciNumber {
    public static void main(String[] args) {
        TribonacciNumber obj = new TribonacciNumber();
        System.out.println(obj.tribonacci(4));
        System.out.println(obj.tribonacci(0));
        System.out.println(obj.tribonacci(37));
    }

    public int tribonacci(int n) {
        if (n < 2) return n;
        if (n == 2) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        //System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}