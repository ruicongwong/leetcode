package array;

import java.util.HashMap;

public class FruitIntoBaskets {
}

class Solution904 {
    public int totalFruit(int[] fruits) {
        if (fruits == null || fruits.length == 0) return 0;
        // key为果树种类
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left ++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}