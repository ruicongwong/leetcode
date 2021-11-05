package greedy;

public class JumpGame {

}

class Solution55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int index = 0;
        for (int i = 0; i <= index; i++) {
           index = Math.max(index, i + nums[i]);
           if(index >= nums.length - 1)return true;
        }
        return false;
    }
}