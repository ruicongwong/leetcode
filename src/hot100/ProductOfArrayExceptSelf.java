package hot100;

public class ProductOfArrayExceptSelf {
}

class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        ans[0] = 1;
        for (int i = 1; i < length; i++) {
            ans[i] = nums[i - 1] * ans[i - 1];
        }
       int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            ans[i] = ans[i] * R;
            R *= nums[i];
        }
        return ans;
    }
}