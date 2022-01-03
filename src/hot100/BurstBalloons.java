package hot100;

public class BurstBalloons {
}

class Solution312 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] tmp = new int[n + 2];
        for (int i = 0; i < n; i++) {
            tmp[i + 1] = nums[i];
        }
        tmp[0] = 1;
        tmp[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        for (int i = 3; i <= n + 2; i++) {
            for (int j = 0; j <= n + 2 - i; j++) {
                int res = 0;
                for (int k = j + 1; k < j + i -1; k++) {
                    int left = dp[j][k];
                    int right = dp[k][j + i -1];
                    int sum = left + right + tmp[k] * tmp[j] * tmp[j + i - 1];
                    res = Math.max(res, sum);
                }
                dp[j][j + i - 1] = res;
            }
        }
        return dp[0][n + 1];
    }
}