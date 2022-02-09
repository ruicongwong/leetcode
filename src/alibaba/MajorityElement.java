package alibaba;

public class MajorityElement {
}

class Solution169 {
    public int majorityElement(int[] nums) {
        int count = 0;
        int can_num = nums[0];
        for (int num : nums) {
            if (can_num == num) {
                count++;
            } else if (--count == 0) {
                can_num = num;
                count = 1;
            }
        }
        return can_num;
    }
}
