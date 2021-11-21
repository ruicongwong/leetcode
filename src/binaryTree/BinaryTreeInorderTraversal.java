package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
}

class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        InOrder(root, result);
        return result;
    }
    private void InOrder(TreeNode root, ArrayList<Integer> result) {
        if(root == null) {
            return;
        }
        InOrder(root.left, result);
        result.add(root.val);
        InOrder(root.right, result);
    }
}