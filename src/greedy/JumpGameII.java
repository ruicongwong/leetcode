package greedy;

public class JumpGameII {
}

class Solution45 {
    public int jump(int[] nums) {
        int position = nums.length;
        int steps = 0;
        while (position > 0){
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
    public int jump_1(int[] nums) {
        int curDistance = 0;
        int ans = 0;
        int nextDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            nextDistance = Math.max(nums[i] + i, nextDistance); // 更新下一步覆盖的最远距离下标
            if (i == curDistance) {
                if (curDistance != nums.length - 1) { // 如果当前覆盖最远距离下标不是终点
                    ans++;
                    curDistance = nextDistance;
                    if (nextDistance >= nums.length - 1) break;
                } else break;
            }
        }
        return ans;
    }
}
