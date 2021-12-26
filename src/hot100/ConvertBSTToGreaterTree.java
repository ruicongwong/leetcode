package hot100;

import binaryTree.TreeNode;

public class ConvertBSTToGreaterTree {
}

class Solution538 {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        help(root);
        return root;
    }

    private void help(TreeNode root) {
        if (root == null) {
            return;
        }
        help(root.right);
        sum += root.val;
        root.val = sum;
        help(root.left);
    }
}