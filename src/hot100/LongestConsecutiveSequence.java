package hot100;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
}

class Solution128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        UnionFind uf = new UnionFind(nums);
        for (int num : nums) {
            uf.union(num, num + 1);
        }
        int max = 1;
        for (int num : nums) {
            max = Math.max(max, uf.find(num) - num + 1);
        }
        return max;
    }
}

class UnionFind {
    private int count;
    private Map<Integer, Integer> parent;

    UnionFind(int[] arr) {
        parent = new HashMap<>();
        for (int i : arr) {
            parent.put(i, i);
        }
        count = parent.size();
    }

    void union(int p, int q) {
        Integer rootP = find(p), rootQ = find(q);
        if (rootP == rootQ) return;
        if (rootP == null || rootQ == null) return;
        parent.put(rootP, rootQ);
        count--;
    }

    Integer find(int p) {
        if (!parent.containsKey(p)) {
            return null;
        }
        int root = p;
        while (root != parent.get(root))
            root = parent.get(root);
        while (p != parent.get(p)) {
            int curr = p;
            parent.put(curr, root);
            p = parent.get(p);
        }
        return root;
    }
}