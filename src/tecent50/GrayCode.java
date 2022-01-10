package tecent50;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
}

class Solution89 {
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(0);
        int head = 1;
        for (int i = 1; i <= n; i++) {
            int m = res.size();
            for (int j = m - 1; j >= 0 ; j--) {
                res.add(res.get(j) + head); // 在最高位加1
            }
            head = head << 1;
        }
        return res;
    }
}