package binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class AverageOfLevelsInBinaryTree {
}

class Solution637 {
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> res = new ArrayList<>();
        if (root == null) return res;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        double sum = 0;
        while (!queue.isEmpty()){
            int n = queue.size();
            sum = 0.0;
            for (int i = 0; i < n; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                sum += treeNode.val;
            }
            res.add((sum / n));
        }
        return res;
    }
}