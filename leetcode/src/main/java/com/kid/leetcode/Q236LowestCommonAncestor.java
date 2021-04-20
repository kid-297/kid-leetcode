package com.kid.leetcode;

import com.kid.leetcode.util.TreeNode;

public class Q236LowestCommonAncestor {

    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
     *
     *
     *
     *  
     *
     * 示例 1:
     *
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * 输出: 3
     * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
     * 示例 2:
     *
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * 输出: 5
     * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
     *  
     *
     * 说明:
     *
     * 所有节点的值都是唯一的。
     * p、q 为不同节点且均存在于给定的二叉树中。
     *
     */

    private TreeNode treeNode ;

    public Q236LowestCommonAncestor() {
        this.treeNode = null;
    }

    public boolean check(TreeNode root, TreeNode p, TreeNode q){
        if (root == null){
            return false;
        }
        boolean checkLeft = check(root.left, p, q);
        boolean checkRight = check(root.right, p, q);


        //判断当前点节点是否是最近公共祖先
        if ((checkLeft && checkRight) || ((p.val == root.val || q.val == root.val) && (checkLeft || checkRight))){
            treeNode = root;
        }
        //判断当前节点是否包含p或者q
        return checkLeft || checkRight || (p.val == root.val || q.val == root.val);
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.check(root,p,q);
        return this.treeNode;
    }


}

/**
 *     private TreeNode ans;
 *
 *     public Solution() {
 *         this.ans = null;
 *     }
 *
 *     private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
 *         if (root == null) return false;
 *         boolean lson = dfs(root.left, p, q);
 *         boolean rson = dfs(root.right, p, q);
 *         if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
 *             ans = root;
 *         }
 *         return lson || rson || (root.val == p.val || root.val == q.val);
 *     }
 *
 *     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
 *         this.dfs(root, p, q);
 *         return this.ans;
 *     }
 */
