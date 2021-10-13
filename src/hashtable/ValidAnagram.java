package hashtable;

public class ValidAnagram {
}

class Solution242 {
    public boolean isAnagram(String s, String t) {
        int[] ints = new int[26];
        for (char c : s.toCharArray()) {
            ints[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            ints[c - 'a']--;
        }
        for (int anInt : ints) {
            if (anInt != 0) return false;
        }
        return true;
    }
}