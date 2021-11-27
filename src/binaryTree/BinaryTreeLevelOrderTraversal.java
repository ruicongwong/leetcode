package binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

}
class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> arrayLists = new ArrayList<>();
        if(root == null) return arrayLists;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode treeNode = queue.pollFirst();
                tmp.add(treeNode.val);
                if(treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if(treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            arrayLists.add(tmp);
        }
        return arrayLists;
    }
}