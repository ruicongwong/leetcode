package hot100;

import java.util.ArrayDeque;

public class RemoveDuplicateLetters {
}

class Solution316 {
    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[chars[i] - 'a'] = i;
        }
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean[] vis = new boolean[26];
        for (int i = 0; i < chars.length; i++) {
            // 栈中已经出现过了
            if (vis[chars[i] - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && stack.peekLast() > chars[i] && lastIndex[stack.peekLast() - 'a'] > i) {
                Character top = stack.removeLast();
                vis[top - 'a'] = false;
            }
            stack.addLast(chars[i]);
            vis[chars[i] - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}