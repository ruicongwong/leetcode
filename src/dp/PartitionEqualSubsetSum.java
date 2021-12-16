package dp;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
}

class Solution416 {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 0) {
            int target = sum / 2;
            int[] dp = new int[target + 1];
            for (int i = 0; i < nums.length; i++) {
                for (int j = target; j >= nums[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                }
            }
            if (dp[target] == target) return true;
        }
        return false;
    }
}