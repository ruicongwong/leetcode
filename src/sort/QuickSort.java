package sort;

import java.util.Random;

public class QuickSort {
}


class Solution912_quick {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = partition(nums, left, right);
        quickSort(nums, left, mid - 1);
        quickSort(nums, mid + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int random = new Random().nextInt(right - left + 1) + left;
        swap(nums, left, random);
        int x = nums[left];

        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && nums[j] >= x) j--;
            if(i < j) nums[i++] = nums[j];
            while (i < j && nums[i] <= x) i++;
            if(i < j ) nums[j--] = nums[i];
        }
        nums[i] = x;
        return i;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}