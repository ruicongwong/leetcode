package array;

public class MinimumSizeSubarraySum {
}

class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                int subLen = right - left + 1;
                res = Math.min(subLen, res);
                sum -= nums[left++];
            }
        }
        if (res == Integer.MAX_VALUE) return 0;
        return res;
    }
}