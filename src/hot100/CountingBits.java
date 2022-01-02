package hot100;

public class CountingBits {
}

class Solution338 {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = getB(i);
        }
        return res;
    }

    private int getB(int x) {
        int ans = 0;
        while (x > 0){
            x = x & (x - 1);
            ans++;
        }
        return ans;
    }
}