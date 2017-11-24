package com.ustbcafe.deepin.algorithms.tree;

/**
 * Created by wangjin18 on 2017/8/28.
 * lowest common ancestor
 * leetcode  236
 */
public class LCA {
     public class TreeNode {
            int val;
             TreeNode left;
            TreeNode right;
            TreeNode(int x) { val = x; }
         }
    public  TreeNode lca(TreeNode root,TreeNode p,TreeNode q){
        if (root == null || root == p || root == q) return root;
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
}

