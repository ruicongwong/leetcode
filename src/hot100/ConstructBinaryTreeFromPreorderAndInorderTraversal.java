package hot100;

import binaryTree.TreeNode;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
}

class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hash.put(inorder[i], i);
        }
        return buildTree(preorder, 0, n - 1, 0 ,n - 1, hash);
    }

    private TreeNode buildTree(int[] preorder, int pleft, int pright, int ileft, int iright, HashMap<Integer, Integer> hash) {
        if (pleft > pright || ileft > iright) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pleft]);
        int pindex = hash.get(root.val);
        root.left = buildTree(preorder,pleft + 1, pindex - ileft + pleft, ileft, pindex - 1, hash);
        root.right = buildTree(preorder,pindex - ileft + pleft + 1, pright, pindex + 1,iright, hash);
        return root;
    }
}