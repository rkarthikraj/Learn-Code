package leetcode.biweekly.contest70;

import java.util.Arrays;

class MinimumCostOfBuyingCandiesWithDiscount {
    public static void main(String[] args) {
        MinimumCostOfBuyingCandiesWithDiscount obj = new MinimumCostOfBuyingCandiesWithDiscount();
        int[] cost1 = {6, 5, 7, 9, 2, 2};
        int[] cost2 = {1, 2, 3};
        int[] cost3 = {5, 5};
        int[] cost4 = {3, 3, 3, 1};

        System.out.println(obj.minimumCost(cost1));
        System.out.println(obj.minimumCost(cost2));
        System.out.println(obj.minimumCost(cost3));
        System.out.println(obj.minimumCost(cost4));
    }

    public int minimumCost(int[] cost) {
        int result = 0;
        int length = cost.length;

        Arrays.sort(cost);

        int count = 0;
        for (int i = length - 1; i >= 0; --i) {
            ++count;

            if ((count % 3) == 0) {
                if (cost[i] > cost[i + 1]) {
                    --i;
                }
                continue;
            }
            result += cost[i];
            // System.out.println(i + "--" + cost[i] + "--" + count);
        }

        return result;
    }
}