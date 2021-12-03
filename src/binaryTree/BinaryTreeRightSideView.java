package binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
}

class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if(i == 0) {
                    res.add(treeNode.val);
                }
            }
        }
        return res;
    }
}