package binaryTree;

import java.util.ArrayDeque;

public class CountCompleteTreeNodes {
}

class Solution222 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = getLeft(root.left);
        int rightDepth = getLeft(root.right);
        if (leftDepth == rightDepth) {
            return (1 << leftDepth) + countNodes(root.right);
        } else {
            return (1 << rightDepth) + countNodes(root.left);
        }
    }

    private int getLeft(TreeNode node) {
        int n = 0;
        if (node == null) return n;
        while (node != null) {
            node = node.left;
            n++;
        }
        return n;
    }
}
