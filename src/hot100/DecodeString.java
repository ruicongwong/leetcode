package hot100;

import java.util.Collections;
import java.util.LinkedList;

public class DecodeString {
}

class Solution394 {
    public String decodeString(String s) {
        int ptr = 0;
        LinkedList<String> stack = new LinkedList<>();
        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                StringBuilder sb = new StringBuilder();
                sb.append(cur);
                while (true) {
                    char c = s.charAt(++ptr);
                    if (Character.isDigit(c)) {
                        sb.append(c);
                    }else break;
                }
                stack.addLast(sb.toString());
            } else if (Character.isLetter(cur) || cur == '[') {
                stack.addLast(String.valueOf(s.charAt(ptr++)));
            } else {
                ++ptr;
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stack.peekLast())) {
                    sub.add(stack.removeLast());
                }
                Collections.reverse(sub);
                StringBuilder t = new StringBuilder();
                for (String s1 : sub) {
                    t.append(s1);
                }
                stack.removeLast();
                int repeat = Integer.parseInt(stack.removeLast());
                StringBuilder sb = new StringBuilder();
                while (repeat-- > 0) {
                    sb.append(t);
                }
                stack.addLast(sb.toString());
            }
        }
        StringBuilder rt = new StringBuilder();
        for (String s1 : stack) {
            rt.append(s1);
        }
        return rt.toString();
    }
}