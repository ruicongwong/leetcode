package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
    找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

    说明：

    所有数字都是正整数。
    解集不能包含重复的组合。
    示例 1: 输入: k = 3, n = 7 输出: [[1,2,4]]

    示例 2: 输入: k = 3, n = 9 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class Lc216 {
}

class Solution216 {
    ArrayList<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        help(n, k, 1);
        return res;
    }

    private void help(int n, int k, int index) {
        if (path.size() == k) {
            if (sum(path) == n) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = index; i <= 9; i++) {
            path.add(i);
            help(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }

    private int sum(ArrayList<Integer> path) {
        int res = 0;
        for (Integer integer : path) {
            res += integer;
        }
        return res;
    }
}
