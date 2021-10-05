package backtracking;

import java.util.*;

/*
    给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

    返回 s 所有可能的分割方案。

    示例: 输入: "aab" 输出: [ ["aa","b"], ["a","a","b"] ]
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        Solution131 solution131 = new Solution131();
        List<List<String>> res = solution131.partition("aab");
        System.out.println(res);
    }
}

class Solution131 {
    ArrayList<List<String>> res = new ArrayList<>();
    ArrayList<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        help(s, 0);
        return res;
    }

    private void help(String s, int index) {
        if(index >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if(isPalindrome(s.substring(index,i+1))) {
                path.add(s.substring(index,i+1));
            }else {
                continue;
            }
            help(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    private boolean isPalindrome(String s){
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i <= j ; i++, j--) {
            if(chars[i] != chars[j]) return false;
        }
        return true;
    }
}