package hot100;

import java.util.Arrays;
import java.util.OptionalInt;

public class MaximumProductSubarray {

}

class Solution152 {
    public int maxProduct(int[] nums) {
        int imax = nums[0], imin = nums[0], ans=nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int mx = imax, mn = imin;
            imax = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            imin = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(imax, ans);
        }
        return ans;
    }
}