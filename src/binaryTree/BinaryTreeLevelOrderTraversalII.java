package binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {
}

class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            ArrayList<Integer> path = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode poll = queue.poll();
                path.add(poll.val);
                if(poll.left != null) {
                    queue.offer(poll.left);
                }
                if(poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            res.add(path);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = res.size() - 1; i >= 0; i--) {
            result.add(res.get(i));
        }
        return result;
    }
}