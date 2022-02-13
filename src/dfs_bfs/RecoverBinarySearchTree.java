package dfs_bfs;

import binaryTree.TreeNode;

public class RecoverBinarySearchTree {
    public static void main(String[] args) {
        Solution99 solution99 = new Solution99();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        solution99.recoverTree(root);
    }
}
class Solution99 {
    TreeNode x;
    TreeNode y;
    TreeNode pre;
    public void recoverTree(TreeNode root) {
        dfs(root);
        if(x!=null && y!=null) {
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        if (pre != null) {
            if (pre.val > node.val) {
                y = node;
                if (x == null) {
                    x = pre;
                }
            }
        }
        pre = node;
        dfs(node.right);
    }
}