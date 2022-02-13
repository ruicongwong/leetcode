package presum;

import java.util.HashMap;

public class CountNumberOfNiceSubarrays {
}

class Solution1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int presum = 0;
        map.put(0, 1);
        for (int num : nums) {
            if (num % 2 == 1) {
                presum ++;
            }
            if (map.containsKey(presum - k)) {
                count += map.get(presum -k);
            }
            map.put(presum, map.getOrDefault(presum, 0) + 1);
        }
        return count;
    }
}