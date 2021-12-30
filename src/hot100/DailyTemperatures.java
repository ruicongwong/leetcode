package hot100;

import java.util.Stack;

public class DailyTemperatures {
}


class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] < temperatures[stack.peek()]) {
                stack.push(i);
            } else if(temperatures[i] == temperatures[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                    Integer pop = stack.pop();
                    res[pop] = i - pop;
                }
                stack.push(i);
            }
        }
        return res;
    }
}