package array;

public class LongestRepeatingCharacterReplacement {
}

class Solution424 {
    public int characterReplacement(String s, int k) {
        char[] chars = s.toCharArray();
        int[] map = new int[26];
        int maxSame = 0;
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < chars.length; right++) {
            map[chars[right] - 'A']++;
            maxSame = Math.max(maxSame, map[chars[right] - 'A']);
            while (maxSame + k < right - left + 1) {
                map[chars[left] - 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}