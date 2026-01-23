class Tuple implements Comparable<Tuple> {
    int row, col, time;
    Tuple(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
    public int compareTo(Tuple other) {
        return this.time - other.time;
    }
}

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        pq.add(new Tuple(0,0,grid[0][0]));
        vis[0][0] = true;
        int[] delrow = {-1, 0, +1, 0};
        int[] delcol = {0, +1, 0, -1};

        while(!pq.isEmpty()) {
            Tuple it = pq.poll();
            int row = it.row;
            int col = it.col;
            int t = it.time;
            if(row == n-1 && col == m-1) return t;

            for(int i = 0; i < 4; i++) {
                int nr = row + delrow[i];
                int nc = col + delcol[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc]) {
                    vis[nr][nc] = true;
                    int newT = Math.max(t, grid[nr][nc]);
                    pq.add(new Tuple(nr, nc, newT));
                }
            }
        }
        return -1;
    }
}