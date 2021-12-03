package binaryTree;

public class InvertBinaryTree {
}

class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        return reverse(root);
    }

    private TreeNode reverse(TreeNode root) {
        if (root == null) return root;
        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        reverse(root.right);
        reverse(root.left);
        return root;
    }
}