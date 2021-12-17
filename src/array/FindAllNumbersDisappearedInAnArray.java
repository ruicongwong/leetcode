package array;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
}

class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = Math.abs(num) - 1;
            if (nums[x] > 0)
            nums[x] = -nums[x];
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] >= 0){
                res.add(i + 1);
            }
        }
        return res;
    }
}