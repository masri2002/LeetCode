package org.example;

public class PathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return add(root, 0, targetSum);
    }

    public boolean add(TreeNode treeNode, int sum, int tsum) {
        if (treeNode == null) {
            return false;
        }
        sum += treeNode.val;

        if (treeNode.left == null && treeNode.right == null && sum == tsum) {
            return true;
        }

        return add(treeNode.left, sum, tsum) || add(treeNode.right, sum, tsum);

    }
}
