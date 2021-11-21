package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
}


class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    private void preOrder(TreeNode root, ArrayList<Integer> result) {
        if(root == null) {
            return;
        }
        result.add(root.val);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }
}