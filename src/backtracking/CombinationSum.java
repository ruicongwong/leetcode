package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
    candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
    对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
 */
public class CombinationSum {
    public static void main(String[] args) {
        Solution39 solution39 = new Solution39();
        int[] arr = {2, 5, 3};
        List<List<Integer>> lists = solution39.combinationSum(arr, 8);
        System.out.println(lists);
    }
}

class Solution39 {
    ArrayList<Integer> path = new ArrayList<>();
    ArrayList<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        help(candidates, target, 0);
        return res;
    }

    private void help(int[] candidates, int target, int index) {
        if (target <= 0) {
            if (target == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = index; i < candidates.length && target - candidates[i] >= 0; i++) {
            int candidate = candidates[i];
            path.add(candidate);
            target -= candidate;
            help(candidates, target, i);
            target += candidate;
            path.remove(path.size() - 1);
        }
    }
}