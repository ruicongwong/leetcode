package hot100;

import binaryTree.TreeNode;

import java.util.ArrayDeque;

public class KthSmallestElementInABST {
}

class Solution230 {
    public int kthSmallest(TreeNode root, int k) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null ){
                stack.addLast(root);
                root = root.left;
            }
            root = stack.removeLast();
            k --;
            if (k == 0){
                break;
            }
            root = root.right;
        }
        return root.val;
    }
}