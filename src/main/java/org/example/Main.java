package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PathSum.TreeNode treeNode = new PathSum.TreeNode(5);
        PathSum.TreeNode treeNode4 = new PathSum.TreeNode(4);
        PathSum.TreeNode treeNode11 = new PathSum.TreeNode(11);
        PathSum.TreeNode treeNode7 = new PathSum.TreeNode(7);
        PathSum.TreeNode treeNode2 = new PathSum.TreeNode(2);
        PathSum.TreeNode treeNode8 = new PathSum.TreeNode(8);
        PathSum.TreeNode treeNode13 = new PathSum.TreeNode(13);
        PathSum.TreeNode treeNode4l = new PathSum.TreeNode(4);
        PathSum.TreeNode treeNode1 = new PathSum.TreeNode(1);

        treeNode.left=treeNode4;
        treeNode.right=treeNode8;
        treeNode4.left=treeNode11;
        treeNode11.left=treeNode7;
        treeNode11.right=treeNode2;
        treeNode8.left=treeNode13;
        treeNode8.right=treeNode4l;
        treeNode4l.right=treeNode1;

        PathSum sum = new PathSum();
        System.out.println(sum.hasPathSum(treeNode,22));
    }
}