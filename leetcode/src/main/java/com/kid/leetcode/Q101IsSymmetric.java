package com.kid.leetcode;

import com.kid.leetcode.util.TreeNode;

public class Q101IsSymmetric {

    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     *
     *  
     *
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     *
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     *  
     *
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     *
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }

    public boolean check(TreeNode node1,TreeNode node2){
        if (node1 == null && node2 == null){
            return true;
        }
        if (node1 == null || node2 == null){
            return false;
        }
        return (node1.val == node2.val) && check(node1.right,node2.left) && check(node1.left,node2.right);
    }


}
