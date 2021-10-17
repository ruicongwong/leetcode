package two_pointer;

public class SquaresOfaSortedArray {
}

class Solution977 {
    public int[] sortedSquares(int[] nums) {
        int negetive = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negetive = i;
            } else {
                break;
            }
        }
        int i = negetive;
        int j = negetive + 1;
        int index = 0;
        int[] res = new int[nums.length];
        while (i >= 0 || j < nums.length) {
            if (i < 0) {
                res[index++] = nums[j] * nums[j];
                j++;
            }else if(j == nums.length) {
                res[index++] = nums[i] * nums[i];
                i --;
            } else if (nums[i] * nums[i] < nums[j] * nums[j]) {
                res[index++] = nums[i] * nums[i];
                i--;
            } else {
                res[index++] = nums[j] * nums[j];
                j++;
            }
        }
        return res;
    }
}