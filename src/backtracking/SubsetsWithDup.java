package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
    给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。

    解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。

    示例 1：

    输入：nums = [1,2,2]
    输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 */
public class SubsetsWithDup {
    public static void main(String[] args) {
        Solution90 solution90 = new Solution90();
        System.out.println(solution90.subsetsWithDup(new int[]{1, 2, 2}));
    }
}

class Solution90 {
    LinkedList<Integer> path = new LinkedList<>();
    ArrayList<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        help(nums, 0);
        return res;
    }

    private void help(int[] nums, int index) {
        res.add(new LinkedList<>(path));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            help(nums, i + 1);
            path.removeLast();
        }
    }
}
