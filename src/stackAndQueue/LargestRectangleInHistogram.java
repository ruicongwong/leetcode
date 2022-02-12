package stackAndQueue;

import java.util.ArrayDeque;

public class LargestRectangleInHistogram {
}

class Solution84 {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        int ans = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                int height = heights[stack.removeLast()];
                int w = 0;
                if (stack.isEmpty()) {
                    w = i;
                } else {
                    w = i - stack.peekLast() - 1;
                }
                ans = Math.max(ans, w * height);
            }
            stack.addLast(i);
        }
        while (!stack.isEmpty()){
            int height = heights[stack.removeLast()];
            int w = 0;
            if (stack.isEmpty()) {
                w = heights.length;
            } else {
                w =  heights.length - stack.peekLast() - 1;
            }
            ans = Math.max(ans, height * w);
        }
        return ans;
    }
}
