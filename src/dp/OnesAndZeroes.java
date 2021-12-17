package dp;

import java.util.HashMap;

public class OnesAndZeroes {
}


class Solution474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < strs.length; i++) {
            int zero = 0;
            int one = 0;
            char[] chars = strs[i].toCharArray();
            for (char aChar : chars) {
                if (aChar == '0'){
                    zero++;
                } else {
                   one++;
                }
            }
            for (int j = m; j >= zero; j--) {
                for (int k = n; k >= one ; k--) {
                    dp[j][k] = Math.max(dp[j][k],dp[j - zero][k - one] + 1);
                }
            }
        }
        return dp[m][n];
    }
}