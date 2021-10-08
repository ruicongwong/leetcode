package backtracking;

import java.util.ArrayList;
import java.util.List;


/*
    给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。

    有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

    例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。

    示例 1：

    输入：s = "25525511135"
    输出：["255.255.11.135","255.255.111.35"]
    示例 2：

    输入：s = "0000"
    输出：["0.0.0.0"]
 */
public class RestoreIPAddresses {
    public static void main(String[] args) {
        Solution93 solution93 = new Solution93();
        List<String> res = solution93.restoreIpAddresses("1111111");
        System.out.println(res);
    }
}

class Solution93 {
    ArrayList<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        help(stringBuilder, 0, 0);
        return res;
    }

    private void help(StringBuilder s, int index, int pointNum) {
        if (pointNum == 3) {
            if (isValid(s, index, s.length() - 1)) {
               res.add(s.toString());
            }
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isValid(s, index, i)) {
               s.insert(i + 1, '.');
               pointNum ++;
               help(s, i + 2, pointNum);
               pointNum --;
               s.deleteCharAt(i + 1);
            } else {
                break;
            }

        }
    }

    private boolean isValid(StringBuilder s, int start, int end) { //判断字符串s在左闭又闭区间[start, end]所组成的数字是否合法
        char[] chars = s.toString().toCharArray();
        if (start > end) {
            return false;
        }
        if (chars[start] == '0' && start != end) {
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (chars[i] > '9' || chars[i] < '0') {
                return false;
            }
            num = num * 10 + (chars[i] - '0');
            if (num > 255) {
                return false;
            }
        }
        return true;
    }
}