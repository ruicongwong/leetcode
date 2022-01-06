package hot100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RemoveInvalidParentheses {
    public static void main(String[] args) {

    }
}

class Solution301 {
    HashSet<String> set = new HashSet<>();
    int max,len,n;
    String s;
    public List<String> removeInvalidParentheses(String _s) {
        s = _s;
        n = s.length();
        int l = 0;
        int r = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                l ++;
            }
            if (c == ')') {
                r ++;
            }
        }
        max = Math.min(l, r);
        dfs(0, "", 0);
        return new ArrayList<>(set);
    }
    private void dfs(int i, String cur, int score) {
        if (score < 0 || score > max) return;
        if (i == n) {
            if (score == 0 && cur.length() >= len) {
                if (cur.length() > len) set.clear();
                len = cur.length();
                set.add(cur);
            }
            return;
        }
        if (s.charAt(i) == '('){
            dfs(i + 1, cur+'(', score+1);
            dfs(i + 1, cur, score);
        }else if (s.charAt(i) == ')'){
            dfs(i + 1, cur+')', score-1);
            dfs(i + 1, cur, score);
        } else {
            dfs(i + 1, cur + s.charAt(i), score);
        }
    }
}