package presum;

import java.util.HashMap;

public class SubarraySumEqualsK {
}

class Solution560 {
    public int subarraySum(int[] nums, int k) {
        int[] presum = new int[nums.length + 1];
        presum[0] = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            presum[i + 1] = nums[i] + presum[i];
        }
        for (int i = 0; i < presum.length; i++) {
            if(map.containsKey(presum[i] - k)) {
                count += map.get(presum[i] - k);
            }
            map.put(presum[i], map.getOrDefault(presum[i], 0) + 1);
        }
        return count;
    }
}