package tecent50;

import java.util.ArrayList;

public class ReverseWordsInAStringIII {
    public static void main(String[] args) {
        Solution557 solution557 = new Solution557();
        System.out.println(solution557.reverseWords("Let's take LeetCode contest"));
    }
}

class Solution557 {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int i = 0;
        while (i <length) {
            int start = i;
            while (i < length && chars[i] != ' '){
                i++;
            }
            int left = start, right = i - 1;
            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            sb.append(aChar);
        }
        return sb.toString();
    }
}