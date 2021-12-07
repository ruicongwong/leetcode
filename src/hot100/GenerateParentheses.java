package hot100;


import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        List<String> strings = solution22.generateParenthesis(3);
        System.out.println(strings);
    }
}

class Solution22 {
    ArrayList<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    char[] p = new char[]{'(', ')'};
    public List<String> generateParenthesis(int n) {
        dfs(n, 0, 0);
        return res;
    }
    private void dfs(int n, int left, int right) {
        if (path.length() == n * 2) {
            String s = path.toString();
            res.add(s);
            return;
        }
        if (left < n) {
            path.append('(');
            dfs(n, left + 1, right);
            path.delete(path.length() - 1, path.length());

        }
        if (left > right) {
            path.append(')');
            dfs(n, left, right + 1);
            path.delete(path.length() - 1, path.length());
        }
    }
}