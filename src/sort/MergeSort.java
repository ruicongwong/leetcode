package sort;

public class MergeSort {
}

class Solution912_merge {
    public int[] sortArray(int[] nums) {
        help(nums, 0, nums.length - 1);
        return nums;
    }

    private void help(int[] nums, int start, int end) {
        if (start >= end) {
             return;
        }
        int mid = start + (end - start) / 2;
        help(nums, start, mid);
        help(nums, mid + 1, end);
        int[] temp = new int[end - start + 1];
        int left = start, right = mid + 1, k = 0;
        while (left <= mid && right <= end) {
            temp[k++] = nums[left] < nums[right] ? nums[left++] : nums[right++];
        }
        while (left <= mid) temp[k++] = nums[left++];
        while (right <= end) temp[k++] = nums[right++];
        for (int i = 0; i < temp.length; i++) {
            nums[start + i] = temp[i];
        }

    }
}