package stackAndQueue;

import java.util.ArrayDeque;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        Solution150 solution150 = new Solution150();
        int i = solution150.evalRPN(new String[]{"11", "2", "+"});
        System.out.println(i);
    }
}

class Solution150 {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            char c = token.charAt(0);
            if (!isOpe(token)){
              stack.push(stoi(token));
            } else if (c == '+') {
                stack.push(stack.pop() + stack.pop());
            } else if (c == '-') {
                stack.push(-stack.pop() + stack.pop());
            } else if (c == '*') {
                stack.push(stack.pop() * stack.pop());
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 / num1);
            }
        }
        return stack.pop();
    }
    private boolean isOpe(String s) {
        return s.length() == 1 && s.charAt(0) < '0' || s.charAt(0) > '9';
    }
    private Integer stoi(String token) {
        return Integer.valueOf(token);
    }
}
