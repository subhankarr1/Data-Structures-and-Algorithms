/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Pair {
    TreeNode node;
    int dis;
    Pair(TreeNode node,int dis) {
        this.node = node;
        this.dis = dis;
    }
}

class Solution {
    private Pair sol(TreeNode root, int d) {
        if(root == null) return new Pair(null, d);
        Pair l = sol(root.left, d+1);
        Pair r = sol(root.right, d+1);
        if(l.dis == r.dis) return new Pair(root, l.dis);
        else return l.dis > r.dis ? l : r;
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Pair t = sol(root, 0);
        return t.node;
    }
}