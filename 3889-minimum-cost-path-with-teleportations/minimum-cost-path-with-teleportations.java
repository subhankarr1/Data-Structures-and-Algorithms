class Solution {
    public int minCost(int[][] grid, int k) {
        int INF = 1_000_000_000;
        int n = grid.length, m = grid[0].length;
        int range = 10000;

        int[][][] dp = new int[n][m][k+1];
        for(int p = 0; p <= k; p++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    dp[i][j][p] = INF;
                }
            }
        }
        int[] bestPre = new int[range + 1];
        Arrays.fill(bestPre, INF);

        for(int t = 0; t <= k; t++) {
            int[] bestCurr = new int[range + 1];
            Arrays.fill(bestCurr, INF);
            
            for(int i = n-1; i >= 0; i--) {
                for(int j = m-1; j >= 0; j--) {
                    if(i == n-1 && j == m-1) dp[i][j][t] = 0;
                    else {
                        int ans = INF;
                        if(i + 1 < n) ans = Math.min(ans, grid[i+1][j] + dp[i+1][j][t]);
                        if(j + 1 < m) ans = Math.min(ans, grid[i][j+1] + dp[i][j+1][t]);
                        if(t > 0) ans = Math.min(ans, bestPre[grid[i][j]]);
                        dp[i][j][t] = ans;
                    }
                    bestCurr[grid[i][j]] = Math.min(bestCurr[grid[i][j]], dp[i][j][t]);
                }
            }
            Arrays.fill(bestPre, INF);
            bestPre[0] = bestCurr[0];
            for(int r = 1; r <= range; r++) {
                bestPre[r] = Math.min(bestPre[r-1], bestCurr[r]);
            }
        }
        return dp[0][0][k];
    }
}