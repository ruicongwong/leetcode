package hot100;

public class RegularExpressionMatching {
}

class Solution10 {
    public boolean isMatch(String s, String p) {
        int sl = s.length();
        int pl = p.length();
        boolean[][] dp = new boolean[sl + 1][pl + 1];
        // dp[i][j] 表示s的前i个是否能被p的前j个匹配
        // p[j] == s[i] dp[i][j] = dp[i - 1][j - 1]
        // p[j] == "." dp[i][j] == dp[i - 1][j - 1]
        // p[j] == "*":
            // p[j - 1] != s[i] dp[i][j] = dp[i][j-2]
            // p[j -1] == s[i] or p[j-1] == ".":
                // dp[i][j] = dp[i -1][j]
                // dp[i][j] = dp[i][j-1]
                // dp[i][j] = dp[i][j-2]
        dp[0][0] = true;
        for (int i = 0; i < pl; i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < sl; i++) {
            for (int j = 0; j < pl; j++) {
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }
            }
        }
        return dp[sl][pl];
    }
}