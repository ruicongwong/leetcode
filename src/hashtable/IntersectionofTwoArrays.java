package hashtable;

import java.util.ArrayList;
import java.util.HashSet;

public class IntersectionofTwoArrays {
}

class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                res.add(num);
            }
        }
        int[] ints = new int[res.size()];
        int index = 0;
        for (Integer re : res) {
            ints[index++] = re;
        }
        return ints;
    }
}