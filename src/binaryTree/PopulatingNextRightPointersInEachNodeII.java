package binaryTree;

import java.util.ArrayDeque;

public class PopulatingNextRightPointersInEachNodeII {
}

class Solution117 {
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