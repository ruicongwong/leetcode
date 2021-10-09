package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        Solution78 solution78 = new Solution78();
        System.out.println(solution78.subsets(new int[]{1, 2, 3}));
    }
}

class Solution78 {
    List<Integer> path = new ArrayList<>();
    ArrayList<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        help(nums, 0);
        return res;
    }

    private void help(int[] nums, int index) {
        res.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            help(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}