package dp;

import java.util.Arrays;

public class LastStoneWeightII {
}

class Solution1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int target = sum >> 1;
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]]+ stones[i]);
            }
        }
        return sum - dp[target]*2;
    }
}