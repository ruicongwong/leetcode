package binaryTree;

import java.util.ArrayDeque;

public class MinimumDepthOfBinaryTree {
}

class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()){
            int n = queue.size();
            res ++;
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                if (node.left == null && node.right == null) return res;
            }
        }
        return res;
    }
}