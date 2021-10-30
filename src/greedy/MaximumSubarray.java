package greedy;

public class MaximumSubarray {
}

class Solution53 {
    public int maxSubArray(int[] nums) {
        // 动规
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            if (dp[i] > res) {
                res = dp[i];
            }
        }
        return res;
    }
    public int maxSubArray_1(int[] nums) {
        // 贪心
        int count = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            if(count > result){
                result = count;
            }
            if (count <= 0) count = 0;
        }
        return result;
    }
}
