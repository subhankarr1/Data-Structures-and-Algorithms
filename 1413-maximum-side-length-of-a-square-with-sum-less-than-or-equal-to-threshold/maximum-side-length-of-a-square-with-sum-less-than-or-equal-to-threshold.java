class Solution {
    private boolean helper(int[][] mat, int[][] rs, int size, int row, int col, int threshold) {
        int sum = 0;
        for (int i = row; i < row + size; i++) {
            sum += rs[i][col + size] - rs[i][col];
            if (sum > threshold)
                return false;
        }
        return true;
    }

    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length, m = mat[0].length;
        int[][] rs = new int[n][m+1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                rs[i][j+1] = rs[i][j] + mat[i][j];
            }
        }
        int low = 1, high = Math.min(n,m), ans = 0;
        while(low <= high) {
            boolean f = false;
            int mid = (low + high) / 2;
            for(int i = 0; i + mid <= n; i++) {
                for(int j = 0; j + mid <= m; j++) {
                    if(helper(mat, rs, mid, i, j, threshold)) {
                        f = true;
                        break;
                    }
                }
            }
            if(f) {
                ans = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return ans;
    }
}