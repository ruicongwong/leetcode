package hot100;

public class MinimumWindowSubstring {
}

class Solution76 {
    public String minWindow(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        int[] tFreq = new int[128];
        char[] tchar = t.toCharArray();
        char[] schar = s.toCharArray();
        for (char c : tchar) {
            tFreq[c]++;
        }
        int begin = 0;
        int left = 0;
        int right = 0;
        int distance = tl;
        int minLen = sl + 1;
        while (right < sl) {
            if (tFreq[schar[right]] > 0) {
                distance--;
            }
            tFreq[schar[right]] --;
            right++;
            while (distance == 0) {
                if (minLen > right - left){
                    minLen = right - left;
                    begin = left;
                }
                if (tFreq[schar[left]] == 0) {
                    distance ++;
                }
                tFreq[schar[left]] ++;
                left++;
            }
        }
        if(minLen == sl + 1){
            return "";
        }
        return s.substring(begin, begin + minLen);
    }
}