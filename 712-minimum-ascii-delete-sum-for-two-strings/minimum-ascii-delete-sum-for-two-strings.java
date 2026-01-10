class Solution {

    private int sol(int i, int j, String s1, String s2, int[][] dp) {
        if(i == 0 && j == 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(i == 0) return sol(i, j-1, s1,s2, dp) + s2.charAt(j-1); 
        if(j == 0) return sol(i-1, j, s1,s2, dp) + s1.charAt(i-1); 

        if(s1.charAt(i-1) == s2.charAt(j-1)) return dp[i][j] = sol(i-1, j-1, s1, s2, dp);
        else return dp[i][j] = Math.min(sol(i-1, j, s1, s2, dp) + s1.charAt(i-1), sol(i, j-1, s1, s2, dp) + s2.charAt(j-1));
    }

    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] i : dp) Arrays.fill(i, -1);
        return sol(n, m, s1, s2, dp);
    }
}