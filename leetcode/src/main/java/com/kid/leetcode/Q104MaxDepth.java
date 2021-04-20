package com.kid.leetcode;

import com.kid.leetcode.util.TreeNode;

public class Q104MaxDepth {

    /**
     * 给定一个二叉树，找出其最大深度。
     *
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最大深度 3 。
     */

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }else{
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left,right) + 1;
        }
    }

    public static void main(String[] args) {
        Q104MaxDepth q104MaxDepth = new Q104MaxDepth();
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(5);
        treeNode.right.right = new TreeNode(7);
        final int i = q104MaxDepth.maxDepth(treeNode);
        System.out.println(i);
    }
}
