package presum;

import java.util.HashMap;

public class SubarraySumsDivisibleByK {
}

class Solution974 {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int presum = 0;
        map.put(0, 1);
        for (int num : nums) {
            presum += num;
            int key = (presum % k + k) % k;
            if (map.containsKey(key)){
                count += map.get(key);
            }
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return count;
    }
}