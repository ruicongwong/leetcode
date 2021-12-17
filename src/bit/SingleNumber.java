package bit;

public class SingleNumber {
}

class Solution136 {
    public int singleNumber(int[] nums) {
        int target = 0;
        for (int num : nums) {
            target ^= num;
        }
        return target;
    }
}