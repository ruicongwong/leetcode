package binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class N_aryTreeLevelOrderTraversal {
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution429 {
    public List<List<Integer>> levelOrder(Node root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            ArrayList<Integer> path = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Node node = queue.poll();
                for (Node child : node.children) {
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