package com.kid.leetcode;

import com.kid.leetcode.util.TreeNode;

public class Q226InvertTree {

    /**
     * 翻转一棵二叉树。
     *
     * 示例：
     *
     * 输入：
     *
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * 输出：
     *
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     *
     * @param root
     * @return
     */

    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return root;
        }
        TreeNode treeNodeLeft = invertTree(root.left);
        TreeNode treeNodeRight = invertTree(root.right);
        root.right = treeNodeLeft;
        root.left = treeNodeRight;
        return root;
    }
}
