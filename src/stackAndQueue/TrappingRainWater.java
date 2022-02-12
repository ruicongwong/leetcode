package stackAndQueue;

import java.util.ArrayDeque;

public class TrappingRainWater {
}

class Solution42 {
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < height.length; ++i) {
            while (!stack.isEmpty() && height[stack.peekLast()] < height[i]) {
                Integer top = stack.pollLast();
                if (stack.isEmpty()) break;
                int w = i - stack.peekLast() - 1;
                int h = Math.min(height[i], height[stack.peekLast()]) - height[top];
                ans += w * h;
            }
            stack.addLast(i);
        }
        return ans;
    }
}