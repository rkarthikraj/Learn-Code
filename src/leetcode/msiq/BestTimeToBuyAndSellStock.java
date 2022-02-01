package leetcode.msiq;

class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int stockPrice = prices[i] - minPrice;
                if (stockPrice > maxProfit) {
                    maxProfit = stockPrice;
                }
            }
        }

        System.out.println("MinPrice: " + minPrice);
        System.out.println("MaxProfit: " + maxProfit);
    }
}