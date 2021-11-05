package greedy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LargestSumAfterKNegations {
}
class Solution1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        nums = IntStream.of(nums)
                .boxed()
                .sorted(((o1, o2) -> Math.abs(o2) - Math.abs(o1)))
                .mapToInt(Integer::intValue).toArray();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if(nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        // 如果k还大于0，那么反复转变数值最小的元素，将k用完
        if (k % 2 == 1) nums[len - 1] = - nums[len - 1];
        return Arrays.stream(nums).sum();
    }
}