package binaryTree;

public class BalancedBinaryTree {
}

class Solution110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return Math.abs(left - right) <= 1 &&  isBalanced(root.left) && isBalanced(root.right);
    }

    private int getDepth(TreeNode node) {
        if (node == null) return 0;
        int left = getDepth(node.left);
        int right = getDepth(node.right);
        return Math.max(left, right) + 1;
    }
}