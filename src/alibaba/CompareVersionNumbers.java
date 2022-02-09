package alibaba;

public class CompareVersionNumbers {
}

class Solution165 {
    public int compareVersion(String version1, String version2) {
        int n = version1.length();
        int m = version2.length();
        int i = 0, j = 0;
        while (i < n || j < m) {
            int x = 0;
            int y = 0;
            while (i < n && version1.charAt(i) != '.') {
                x = x * 10 + version1.charAt(i) - '0';
                i++;
            }
            i++;
            while (j < m && version2.charAt(j) != '.') {
                y = y * 10 + version2.charAt(j) - '0';
                j++;
            }
            j++;
            if (x < y) return -1;
            if (x > y) return 1;
        }
        return 0;
    }
}