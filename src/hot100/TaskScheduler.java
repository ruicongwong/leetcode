package hot100;

public class TaskScheduler {
}

class Solution621 {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            count[tasks[i] - 'A']++;
        }
        int max = 0;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max,count[i]);
        }
        int maxCount = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] == max){
                maxCount++;
            }
        }
        return Math.max((max-1)*(n+1)+maxCount,tasks.length);
    }
}