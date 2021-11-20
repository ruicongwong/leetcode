package greedy;

public class BestTimeToBuyAndSellStockWithTransactionFee {

}

class Solution714 {
    public int maxProfit(int[] prices, int fee) {
        int res = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) minPrice = prices[i];
            if (prices[i] >= minPrice && prices[i] - minPrice <= fee) continue;
            if (prices[i] > minPrice + fee) {
                res += prices[i] - minPrice - fee;
                minPrice = prices[i] - fee;
            }
        }
        return res;
    }
}
