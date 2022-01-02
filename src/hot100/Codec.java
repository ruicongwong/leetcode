package hot100;

import binaryTree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return help1(root, "");
    }

    private String help1(TreeNode root, String s) {
        if (root == null) {
            s += "None,";
        } else {
            s += root.val + ",";
            s = help1(root.left, s);
            s = help1(root.right, s);
        }
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        LinkedList<String> dataList = new LinkedList<>(Arrays.asList(split));
        return help2(dataList);
    }

    private TreeNode help2(List<String> split) {
        if (split.get(0).equals("None")) {
            split.remove(0);
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(split.get(0)));
        split.remove(0);
        treeNode.left = help2(split);
        treeNode.right = help2(split);
        return treeNode;
    }
}