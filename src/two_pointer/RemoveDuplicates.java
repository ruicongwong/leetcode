package two_pointer;

public class RemoveDuplicates {
    public static void main(String[] args) {

    }
}

class Solution26 {
    public int removeDuplicates(int[] nums) {
        int p = 0;
        for (int q = 1; q < nums.length; q++) {
            if(nums[q] != nums[p]){
                nums[++p] = nums[q];
            }
        }
        return p + 1;
    }
}
