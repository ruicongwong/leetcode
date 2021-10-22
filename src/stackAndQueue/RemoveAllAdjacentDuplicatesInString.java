package stackAndQueue;


public class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        Solution1047 solution1047 = new Solution1047();
        String abbaca = solution1047.removeDuplicates("abbaca");
        System.out.println(abbaca);
    }
}

class Solution1047 {
    public String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        int index = 0;
        char[] stack = new char[s.length()];
        for (char aChar : chars) {
            if (index > 0 && stack[index - 1] == aChar) {
                index--;
            } else {
                stack[index++] = aChar;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < index; i++) {
            sb.append(stack[i]);
        }
        return sb.toString();
    }
}
