package hot100;

public class MedianOfTwoSortedArrays {

}

class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p1 = 0;
        int p2 = 0;
        int m = nums1.length;
        int n = nums2.length;
        int[] ints = new int[m + n];
        int index = 0;
        while (p1 != m && p2 != n) {
            if(nums1[p1] <= nums2[p2]) {
                ints[index++] = nums1[p1++];
            } else {
                ints[index++] = nums2[p2++];
            }
        }
        while (p1 != m) {
            ints[index++] = nums1[p1++];
        }
        while(p2 != n) {
            ints[index++] = nums2[p2++];
        }
        if (index % 2 ==0) {
            return (ints[index/2 - 1] + ints[index/2]) / 2.0;
        } else {
            return ints[index/2];
        }
    }
}