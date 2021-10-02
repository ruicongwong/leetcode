package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*
    给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

    给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

    "", // 0
    "", // 1
    "abc", // 2
    "def", // 3
    "ghi", // 4
    "jkl", // 5
    "mno", // 6
    "pqrs", // 7
    "tuv", // 8
    "wxyz", // 9

    示例: 输入："23" 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

    说明：尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
     */
public class Lc17 {
}


class Solution17 {
    ArrayList<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return res;
        char[] chars = digits.toCharArray();
        help(chars, 0);
        return res;
    }

    private void help(char[] chars, int index) { // index表示当前处理到的digits下标
        if(sb.length() == chars.length){
            res.add(sb.toString());
            return;
        }
        String s = numString[chars[index] - '0'];
        for (int i = 0; i < s.length(); i++) {  // 循环的范围由你要进行迭代的目标决定
            sb.append(s.charAt(i));
            help(chars, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}