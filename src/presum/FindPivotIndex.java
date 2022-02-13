package presum;

public class FindPivotIndex {
    public static void main(String[] args) {
        Solution724 solution724 = new Solution724();
        System.out.println(solution724.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }
}

class Solution724 {
    public int pivotIndex(int[] nums) {
        int[] presum = new int[nums.length + 1];
        presum[0] = 0;
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            presum[i + 1] = nums[i] + presum[i];
            n += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (presum[i] == n - presum[i] - nums[i]){
                return i;
            }
        }
        return -1;
    }
}