package two_pointer;

public class RemoveElement {
    public static void main(String[] args) {

    }
}

class Solution27 {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if(nums[fast] != val){
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}
