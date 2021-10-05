package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
    给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

    示例:
    输入: n = 4, k = 2
    输出:
    [
    [2,4],
    [3,4],
    [2,3],
    [1,2],
    [1,3],
    [1,4],
    ]
 */
public class  Combinations {
    public static void main(String[] args) {
        Solution77 solution77 = new Solution77();
        List<List<Integer>> combine = solution77.combine(4, 2);
        System.out.println(combine);
    }
}

class Solution77 {
    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        int index = 1;
        help(n,k,index);
        return res;
    }

    private void help(int n, int k, int index) {
        if (path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i <= n; i++) {
            path.add(i);
            help(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }
}