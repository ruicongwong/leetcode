package binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class N_aryTreeLevelOrderTraversal {
}

class MulNode {
    public int val;
    public List<MulNode> children;

    public MulNode() {}

    public MulNode(int _val) {
        val = _val;
    }

    public MulNode(int _val, List<MulNode> _children) {
        val = _val;
        children = _children;
    }
};

class Solution429 {
    public List<List<Integer>> levelOrder(MulNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        ArrayDeque<MulNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            ArrayList<Integer> path = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                MulNode node = queue.poll();
                for (MulNode child : node.children) {
                    if (child != null) {
                        queue.add(child);
                    }
                }
                path.add(node.val);
            }
            res.add(path);
        }
        return res;
    }
}