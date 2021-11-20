package greedy;

public class MonotoneIncreasingDigits {
}

class Solution738 {
    public int monotoneIncreasingDigits(int n) {
        if(n == 0) return 0;
        char[] chars = Integer.toString(n).toCharArray();
        int start = Integer.MAX_VALUE;
        for (int i = chars.length - 1; i > 0; i--) {
            if(chars[i] < chars[i - 1]) {
                chars[i - 1]--;
                start = i;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if(i >= start) {
                res.append('9');
            }else res.append(chars[i]);
        }
        return Integer.parseInt(res.toString());
    }
}
