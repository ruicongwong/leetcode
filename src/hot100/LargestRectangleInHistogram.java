package hot100;

import java.util.ArrayDeque;

public class LargestRectangleInHistogram {
}

class Solution84 {
    public int largestRectangleArea(int[] heights) {
        int area = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]){
                int height = heights[stack.removeLast()];
                int w = 0;
                if (stack.isEmpty()) {
                    w = i;
                } else {
                    w = i - stack.peekLast() - 1;
                }
                area = Math.max(area, height * w);
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
            area = Math.max(area, height * w);
        }
        return area;
    }
}