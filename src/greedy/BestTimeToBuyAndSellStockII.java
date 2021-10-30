package greedy;

public class BestTimeToBuyAndSellStockII {
}

class Solution122 {
    public int maxProfit(int[] prices) {
        // 贪心
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            result += Math.max(0, prices[i] - prices[i - 1]);
        }
        return result;
    }
    public int maxProfit_1(int[] prices) {
        // 动规
        // dp[i][0]代表第i天持有的最多利润;
        // dp[i][1]代表持股票之后持有的最多利润;
        int n = prices.length;
        if(n == 1) return 0;
        int[][] dp = new int[n][2];
        dp[0][1] -= prices[0];
        for (int i = 1; i < prices.length; i++) {
            // max(买第i天的股票，之前已经买过股票）
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
            // max(之前买过股票把股票给卖了，之前已经卖了)
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}
