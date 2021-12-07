package hot100;

public class NextPermutation {
    public static void main(String[] args) {
        Solution31 solution31 = new Solution31();
        solution31.nextPermutation(new int[]{3, 2, 1});
    }
}
class Solution31 {
    public void nextPermutation(int[] nums) {
        int l = nums.length;
        int m = -1;
        for (int i = l - 1; i >= 1; i--) {
            if(nums[i] > nums[i - 1]) {
                m = i - 1;
                break;
            }
        }
        for (int i = l - 1; i >= 0; i--) {
            if (m == -1) {
                break;
            }
            if(nums[i] > nums[m]) {
                swap(nums, i, m);
                break;
            }
        }
        int left = m + 1;
        int right = l - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}