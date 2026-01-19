class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length, m = mat[0].length;
        int[][] prefix = new int[n+1][m+1];
        int ans = 0, size = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + mat[i-1][j-1];
            }
        }
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                while(i + size <= n && j + size <= m && prefix[i+size][j+size] - prefix[i+size][j] - prefix[i][j+size] + prefix[i][j] <= threshold) {
                    ans = size++;
                }
            }
        }
        return ans;
    }
}