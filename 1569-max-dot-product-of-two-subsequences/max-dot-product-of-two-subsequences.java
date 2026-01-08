class Solution {

    private int sol(int i, int j, int[] nums1, int[]nums2, int[][] dp) {

        if(i < 0|| j < 0) return Integer.MIN_VALUE;
        if(dp[i][j] != -1) return dp[i][j];

        int product = nums1[i] * nums2[j];
        int include = product + Math.max(0, sol(i-1, j-1, nums1, nums2, dp));
        int ex1 = sol(i-1, j, nums1, nums2, dp);
        int ex2 = sol(i, j-1, nums1, nums2, dp);

        return dp[i][j] = Math.max(include, Math.max(ex1, ex2));
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n][m];
        for(int[] i: dp) Arrays.fill(i, -1);
        return sol(n-1, m-1, nums1, nums2, dp);
    }
}