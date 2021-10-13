package hashtable;

import java.util.HashSet;

public class HappyNumber {
}

class Solution202 {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (true){
            int sum = getSum(n);
            if (sum == 1) {
                return true;
            }
            if (set.contains(sum)) {
                return false;
            } else {
                set.add(sum);
            }
            n = sum;
        }
    }

    private int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}

