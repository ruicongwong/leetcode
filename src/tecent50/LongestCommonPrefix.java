package tecent50;

public class LongestCommonPrefix {
}

class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        String ans = strs[0];
        for (int i = 0; i < strs.length; i++) {
            int j = 0;
            while (j < ans.length() && j < strs[i].length()){
                if (ans.charAt(j) != strs[i].charAt(j)){
                    break;
                }
                j ++;
            }
            ans = ans.substring(0, j);
            if(ans.equals("")) return ans;
        }
        return ans;
    }
}