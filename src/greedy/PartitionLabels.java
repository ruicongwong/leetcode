package greedy;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
}

class Solution763 {
    public List<Integer> partitionLabels(String s) {
        char[] chars = s.toCharArray();
        int[] hash = new int[26];
        for (int i = 0; i < chars.length; i++) {
            hash[chars[i] - 'a'] = i;
        }
        ArrayList<Integer> res = new ArrayList<>();
        int right = 0;
        int left = 0;
        for (int i = 0; i < chars.length; i++) {
            right = Math.max(right, hash[chars[i] - 'a']);
            if (right == i){
                res.add(right - left + 1);
                left = i + 1;
            }
        }
        return res;
    }
}