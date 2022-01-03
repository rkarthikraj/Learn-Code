package leetcode.ds1;

class BuySellStock {
    public static void main(String[] args) {
        BuySellStock obj = new BuySellStock();
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};
        int[] prices3 = {2, 4, 1};

        System.out.println(obj.maxProfit(prices1));
        System.out.println(obj.maxProfit(prices2));
        System.out.println(obj.maxProfit(prices3));
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        if (prices.length > 0) {
            int min = prices[0];
            int max = prices[0];
            int tempMax = 0;

            for (int i = 1; i < prices.length; i++) {
                if (prices[i] < min) {
                    min = Math.min(min, prices[i]);
                    max = min;
                    profit = Math.max(profit, (max - min));
                } else if (prices[i] > min) {
                    tempMax = prices[i];
                    max = Math.max(max, tempMax);
                    profit = Math.max(profit, (max - min));
                }
            }

            return profit;
        }
        return profit;
    }
}