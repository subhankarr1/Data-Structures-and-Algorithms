class Solution {

    private boolean helper(int[][] grid, int row, int col, int[][] prefixRow, int[][] prefixCol, int size) {
        int target = prefixRow[row][col + size] - prefixRow[row][col];
        for(int i = row; i < row + size; i++) {
            if(prefixRow[i][col + size] - prefixRow[i][col] != target) {
                return false;
            }
        }
        for(int j = col; j < col + size; j++) {
            if(prefixCol[row + size][j] - prefixCol[row][j] != target) {
                return false;
            }
        }
        int diag1 = 0, diag2 = 0;
        for(int i = 0; i < size; i++) {
            diag1 += grid[row + i][col + i];
            diag2 += grid[row + i][col + size - 1 - i];
        }
        if(diag1 != target || diag2 != target) return false;
        return true;
    }

    public int largestMagicSquare(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] prefixRow = new int[n][m + 1];
        int[][] prefixCol = new int[n + 1][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prefixRow[i][j + 1] = prefixRow[i][j] + grid[i][j];
                prefixCol[i + 1][j] = prefixCol[i][j] + grid[i][j];
            }
        }
        int mxSize = Math.min(n, m);
        while (mxSize >= 2) {
            for (int i = 0; i + mxSize <= n; i++) {
                for (int j = 0; j + mxSize <= m; j++) {
                    if (helper(grid, i, j, prefixRow, prefixCol, mxSize)) {
                        return mxSize;
                    }
                }
            }
            mxSize--;
        }
        return 1;
    }
}