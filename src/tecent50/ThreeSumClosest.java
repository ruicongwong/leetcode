package tecent50;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        int[] test = new int[]{1 ,1, 1, 0};
        System.out.println(solution16.threeSumClosest(test, -100));
    }
}

class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int fix = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            int temp;
            while (left < right) {
                temp = fix + nums[left] + nums[right];
                if (Math.abs(target - ans) > Math.abs(target - temp)) {
                    ans = temp;
                }
                if (temp == target) {
                    break;
                }
                if (temp < target){
                    left++;
                }
                if (temp > target) {
                    right --;
                }
            }
        }
        return ans;
    }
}