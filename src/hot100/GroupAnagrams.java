package hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
}

class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            int[] counts = new int[26];
            for (char aChar : chars) {
                counts[aChar - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char)('a' + i));
                    sb.append(counts[i]);
                }
            }
            List<String> orDefault = map.getOrDefault(sb.toString(), new ArrayList<>());
            orDefault.add(str);
            map.put(sb.toString(), orDefault);
        }
        return new ArrayList<>(map.values());
    }
}