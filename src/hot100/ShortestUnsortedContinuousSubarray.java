package hot100;

public class ShortestUnsortedContinuousSubarray {
}


class Solution581 {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int min = nums[len - 1];
        int max = nums[0];
        int left = 0;
        int right = -1;
        for (int i = 0; i < len; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                right = i;
            }
            if (nums[len - i - 1] <= min) {
                min = nums[len - i -1];
            } else {
                left = len - i -1;
            }
        }
        return right - left + 1;
    }
}