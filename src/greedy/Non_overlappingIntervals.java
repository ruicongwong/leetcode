package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Non_overlappingIntervals {
    public static void main(String[] args) {
        Solution435 solution435 = new Solution435();
        int i = solution435.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}});
        System.out.println(i);
    }
}

class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int res = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[i - 1][1]) {
                res++;
            } else {
                intervals[i][1] = Math.min(intervals[i - 1][1], intervals[i][1]);
            }
        }
        return intervals.length - res;
    }
}
