package binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class FindLargestValueInEachTreeRow {

}

class Solution515 {
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.val > max) max = treeNode.val;
            }
            res.add(max);
        }
        return res;
    }
}