package presum;

import java.util.HashMap;

public class ContinuousSubarraySum {
}

class Solution523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int count = 0;
        int presum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            presum += nums[i];
            int key = k == 0 ? presum : presum % k;
            if (map.containsKey(key)) {
                if (i - map.get(key) >= 2) {
                    return true;
                }
                continue;
            }
            map.put(key, i);
        }
        return false;
    }
}