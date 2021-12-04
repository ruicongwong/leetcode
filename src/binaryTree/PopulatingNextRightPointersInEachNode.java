package binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class PopulatingNextRightPointersInEachNode {
}

class PointerNode {
    public int val;
    public PointerNode left;
    public PointerNode right;
    public PointerNode next;

    public PointerNode() {}

    public PointerNode(int _val) {
        val = _val;
    }

    public PointerNode(int _val, PointerNode _left, PointerNode _right, PointerNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
class Solution116 {
    public PointerNode connect(PointerNode root) {
        if (root == null) return null;
        ArrayDeque<PointerNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                PointerNode node = queue.poll();
                if(i == n - 1) {
                    node.next = null;
                } else {
                    node.next = queue.peek();
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return root;
    }
}
