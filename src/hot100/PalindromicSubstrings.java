package hot100;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        Solution647 solution647 = new Solution647();
        int aaa = solution647.countSubstrings("aaa");
        System.out.println(aaa);
    }
}

class Solution647 {
    public int countSubstrings(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int a = 0;
        for (int j = 0; j < length; j++) {
            for (int i = 0; i <= j ; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    a++;
                }
            }
        }
        return a;
    }
}