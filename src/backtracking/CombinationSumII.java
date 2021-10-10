package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;



/*
    给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

    candidates 中的每个数字在每个组合中只能使用一次。

    注意：解集不能包含重复的组合。

    示例 1:

    输入: candidates =
    [10,1,2,7,6,1,5]
    , target =
    8
    ,
    输出:
    [
    [1,1,6],
    [1,2,5],
    [1,7],
    [2,6]
    ]
 */
public class CombinationSumII {
    public static void main(String[] args) {
        Solution40 solution40 = new Solution40();
        System.out.println(solution40.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }
}


class Solution40 {
    LinkedList<Integer> path = new LinkedList<>();
    ArrayList<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        help(candidates, target, 0);
       return res;
    }
    private void help(int[] candidates, int target, int index) {
        if (target == 0) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = index; i < candidates.length && target > 0; i++) {
            if (i > index && candidates[i-1] == candidates[i]) {
                continue;
            }
            path.add(candidates[i]);
            help(candidates, target - candidates[i], i + 1);
            path.removeLast();
        }
    }
}