package tecent50;

public class PowerofTwo {
}

class Solution231 {
    public boolean isPowerOfTwo(int n) {
        // n & (n - 1) 可以把最低位的1移除
        return n > 0 && (n & (n - 1) )== 0;
    }
}