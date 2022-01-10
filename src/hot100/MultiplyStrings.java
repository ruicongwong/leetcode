package hot100;

public class MultiplyStrings {
    public static void main(String[] args) {
        Solution43 solution43 = new Solution43();
        System.out.println(solution43.multiply("123", "456"));
    }
}

class Solution43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        StringBuilder ans = new StringBuilder();
        for (int i = n2.length - 1; i >= 0; i--) {
            int t = n2[i] - '0';
            int carry = 0;
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < n2.length - 1 - i; k++) {
                sb.append('0');
            }
            for (int j = n1.length - 1; j >= 0; j--) {
                int res = t * (n1[j] - '0') + carry;
                carry = res / 10;
                sb.append(res % 10);
            }
            if (carry != 0){
                sb.append(carry);
            }
            ans = add(ans,sb);
        }
        return ans.reverse().toString();
    }

    private StringBuilder add(StringBuilder a, StringBuilder b) {
        if (a.length() == 0) {
            return b;
        }
        StringBuilder ans = new StringBuilder();
        int pa = 0, pb = 0;
        int carry = 0;
        while (pa < a.length() || pb < b.length()) {
            int t1 = pa < a.length() ? a.charAt(pa) - '0' : 0;
            int t2 = pb < b.length() ? b.charAt(pb) - '0' : 0;
            int res = t1 + t2 + carry;
            carry = res / 10;
            ans.append(res % 10);
            pa++;
            pb++;
        }
        if (carry != 0) {
            ans.append(1);
        }
        return ans;
    }
}