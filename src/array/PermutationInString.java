package array;


public class PermutationInString {
}

class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return  false;
        int[] cnt = new int[26];
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            cnt[s1.charAt(i) - 'a']--;
            cnt[s2.charAt(i) - 'a']++;
        }
        for (int i : cnt) {
            if (i != 0) diff ++;
        }
        if (diff == 0) return true;
        for (int right = s1.length(); right < s2.length(); right++) {
            char x = s2.charAt(right);
            char y = s2.charAt(right - s1.length());
            if (x == y) continue;
            if (cnt[x - 'a'] == 0) diff++;
            ++cnt[x - 'a'];
            if(cnt[x - 'a'] == 0) diff--;
            if (cnt[y - 'a'] == 0) diff++;
            --cnt[y - 'a'];
            if(cnt[y - 'a'] == 0) diff--;
            if (diff == 0) return true;
        }
        return false;
    }
}