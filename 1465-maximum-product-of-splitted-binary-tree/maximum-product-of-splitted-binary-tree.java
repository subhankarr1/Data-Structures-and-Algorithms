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
    long maxi = Integer.MIN_VALUE;

    private long totalSum(TreeNode root) {
        if (root == null)
            return 0;
        return root.val + totalSum(root.left) + totalSum(root.right);
    }

    private long dfs(TreeNode root, long sum) {
        if (root == null)
            return 0;
        long l = dfs(root.left, sum);
        long r = dfs(root.right, sum);
        long currSum = root.val + l + r;
        long currProduct = (sum - currSum) * currSum;
        maxi = Math.max(maxi, currProduct);
        return currSum;
    }

    public int maxProduct(TreeNode root) {
        if (root == null)
            return 0;
        long MOD = 1_000_000_007;
        long totSum = totalSum(root);
        dfs(root, totSum);
        return (int) (maxi % MOD);
    }
}