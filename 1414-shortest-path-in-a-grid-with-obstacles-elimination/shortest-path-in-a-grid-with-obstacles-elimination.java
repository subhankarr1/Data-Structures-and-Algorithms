class state {
    int distence, row, col, distK;

    state(int distence, int row, int col, int distK) {
        this.distence = distence;
        this.row = row;
        this.col = col;
        this.distK = distK;
    }
}

class Solution {
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        boolean[][][] vis = new boolean[n][m][k + 1];
        Queue<state> q = new LinkedList<>();
        q.add(new state(0, 0, 0, k));
        vis[0][0][k] = true;

        int[] delrow = { -1, 0, +1, 0 };
        int[] delcol = { 0, +1, 0, -1 };

        while (!q.isEmpty()) {
            state it = q.poll();
            int dist = it.distence;
            int row = it.row;
            int col = it.col;
            int dk = it.distK;
            if (row == n - 1 && col == m - 1) return dist;
            for (int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m) {
                    int newDistK = dk - grid[nrow][ncol];
                    if (newDistK >= 0 && !vis[nrow][ncol][newDistK]) {
                        vis[nrow][ncol][newDistK] = true;
                        q.add(new state(dist + 1, nrow, ncol, newDistK));
                    }
                }
            }
        }
        return -1;
    }
}