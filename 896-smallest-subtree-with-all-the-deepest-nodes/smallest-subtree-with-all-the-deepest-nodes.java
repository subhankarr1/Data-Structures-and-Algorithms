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
class Solution {

    private int height(TreeNode root) {
        if(root == null) return 0;
        int l = height(root.left);
        int r = height(root.right);
        return 1 + Math.max(l, r);
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int l = height(root.left);
        int r = height(root.right);
        if(l == r) return root;
        TreeNode node;
        if (l > r) node = subtreeWithAllDeepest(root.left);
        else  node = subtreeWithAllDeepest(root.right);

        return node;
    }
}