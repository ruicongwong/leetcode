package sort;

import java.util.Random;

public class KthLargestElementInAnArray {
}

class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);

    }

    private int quickSelect(int[] a, int l, int r, int index) {
        int q = randomPartition(a, l ,r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    private int randomPartition(int[] a, int l, int r) {
        int random = new Random().nextInt(r - l + 1) + l;
        swap(a, l, random);
        int x = a[l];
        int i = l;
        int j = r;
        while (i < j){
            while (i < j && a[j] >= x) j--;
            if (i < j) a[i++] = a[j];
            while (i < j && a[i] <= x) i++;
            if(i < j) a[j--] = a[i];
        }
        a[i] = x;
        return i;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}