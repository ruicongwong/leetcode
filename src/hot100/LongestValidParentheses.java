package hot100;

public class LongestValidParentheses {
}

class Solution32 {
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        int[] dp = new int[n];
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (chars[i] == '(') {
                dp[i] = 0;
            } else if (chars[i] == ')') {
                if (chars[i - 1] == '(') {
                    dp[i] = 2;
                    if (i - 2 >= 0) {
                        dp[i] = dp[i - 2] + 2;
                    }
                }else {
                    if (i - dp[i -1] - 1 >= 0 && chars[i - dp[i -1] - 1] == '(') {
                        dp[i] = dp[i - 1] + 2;
                        if(i - dp[i - 1] - 2 >= 0) {
                            dp[i] = dp[i -1] + 2 + dp[i - dp[i - 1] - 2];
                        }
                    }
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}