package hot100;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
}

class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> ans = new ArrayList<>();
        int sl = s.length();
        int pl = p.length();
        if (sl < pl) return ans;
        int[] count = new int[256];
        for (int i = 0; i < pl; i++) {
            count[s.charAt(i)]++;
            count[p.charAt(i)]--;
        }
        int diff = 0;
        for (int i : count) {
            if (i != 0) {
                diff++;
            }
        }
        if (diff == 0) {
            ans.add(0);
        }
        for (int i = 0; i < sl - pl; i++) {
            if(count[s.charAt(i)] == 1) {
                diff--;
            } else if(count[s.charAt(i)] == 0) {
                diff++;
            }
            --count[s.charAt(i)];
            if(count[s.charAt(i + pl)] == 0) {
                diff++;
            } else if(count[s.charAt(i + pl)] == -1) {
                diff--;
            }
            ++count[s.charAt(i + pl)];
            if (diff == 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}