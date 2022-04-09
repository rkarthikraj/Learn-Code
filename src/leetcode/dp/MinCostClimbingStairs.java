package leetcode.dp;

import java.util.Arrays;

class MinCostClimbingStairs {
    public static void main(String[] args) {
        MinCostClimbingStairs obj = new MinCostClimbingStairs();
        System.out.println(obj.minCostClimbingStairs(new int[]{1, 3, 2, 5, 6, 10, 4}));
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length + 1];

        for (int i = 2; i < minCost.length; i++) {
            int oneStep = minCost[i - 1] + cost[i - 1];
            int twoStep = minCost[i - 2] + cost[i - 2];
            minCost[i] = Math.min(oneStep, twoStep);
        }

        System.out.println(Arrays.toString(minCost));

        return minCost[minCost.length - 1];
    }
}