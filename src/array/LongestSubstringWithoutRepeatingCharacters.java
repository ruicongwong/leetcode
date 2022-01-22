package array;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
}
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            map.put(chars[right], map.getOrDefault(chars[right], 0) + 1);
            while (map.get(chars[right]) > 1) {
                map.put(chars[left], map.get(chars[left]) - 1);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}