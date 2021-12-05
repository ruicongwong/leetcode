package binaryTree;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;


public class BinaryTreePaths {
}

class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        if (root == null) return res;
        ArrayDeque<Object> stack = new ArrayDeque<>();
        stack.offer(root);
        stack.offer(root.val + "");
        while (!stack.isEmpty()) {
            String path = (String)stack.pollLast();
            TreeNode treeNode = (TreeNode)stack.pollLast();
            if (treeNode.left == null && treeNode.right == null) {
                res.add(path);
            }
            if (treeNode.right != null) {
                stack.offer(treeNode.right);
                stack.offer(path + "->" + treeNode.right.val);
            }
            if (treeNode.left != null) {
                stack.offer(treeNode.left);
                stack.offer(path + "->" + treeNode.left.val);
            }
        }
        return res;
    }
}