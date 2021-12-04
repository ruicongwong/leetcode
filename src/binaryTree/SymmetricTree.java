package binaryTree;

public class SymmetricTree {
}

class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return help(root.left, root.right);
    }

    private boolean help(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (right == null && left != null) return false;
        if (right != null && left == null) return false;
        if (right.val != left.val) return false;

        boolean outside = help(left.left, right.right);
        boolean inside = help(left.right, right.left);
        return  outside && inside;
    }
}
