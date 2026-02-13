class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        long[][][] dp = new long[n + 1][m + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                Arrays.fill(dp[i][j], Long.MIN_VALUE);
                dp[i][j][0] = 0;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                for (int s = 1; s <= k; s++) {
                    long take = Long.MIN_VALUE;
                    if (dp[i + 1][j + 1][s - 1] != Long.MIN_VALUE) {
                        take = nums1[i] * 1L * nums2[j] + dp[i + 1][j + 1][s - 1];
                    }
                    long notTake1 = dp[i + 1][j][s];
                    long notTake2 = dp[i][j + 1][s];

                    dp[i][j][s] = Math.max(take, Math.max(notTake1, notTake2));
                }
            }
        }
        return dp[0][0][k];
    }
}