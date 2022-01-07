package hot100;

import java.util.ArrayDeque;

public class MaximalRectangle {
}

class Solution85 {
    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        int[] height = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    height[j] += 1;
                } else {
                    height[j] = 0;
                }
            }
            res = Math.max(res, largestRectangleArea(height));
        }
        return res;
    }
    private int largestRectangleArea(int[] heights) {
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