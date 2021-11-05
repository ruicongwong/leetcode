package greedy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Candy {
}


class Solution135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candys = new int[n];
        Arrays.fill(candys, 1);
        for (int i = 1; i < n; i++) {
            if(ratings[i] > ratings[i - 1]) {
                candys[i] = candys[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) {
                candys[i] = Math.max(candys[i + 1] + 1, candys[i]);
            }
        }
        return IntStream.of(candys).sum();
    }
}