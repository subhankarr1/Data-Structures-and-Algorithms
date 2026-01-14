class tuple implements Comparable<tuple> {
    int row, col, cost;
    tuple(int row, int col, int cost) {
        this.row = row;
        this.col = col;
        this.cost = cost;
    }
    public int compareTo(tuple other) {
        return this.cost - other.cost;
    }
}

class Solution {
    public int minimumObstacles(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dist = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dist[i][j] = (int)(1e9);
            }
        }
        PriorityQueue<tuple> pq = new PriorityQueue<>();
        pq.add(new tuple(0,0,0));
        dist[0][0] = 0;

        int[] delrow = {-1, 0, +1, 0};
        int[] delcol = {0, +1, 0, -1};

        while(!pq.isEmpty()) {
            tuple it = pq.poll();
            int row = it.row;
            int col = it.col;
            int cost = it.cost;
            if(row == n-1 && col == m-1) return cost;

            for(int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m) {
                    int newCost = cost + grid[nrow][ncol];
                    if(newCost < dist[nrow][ncol]) {
                        dist[nrow][ncol] = newCost;
                        pq.add(new tuple(nrow, ncol, newCost));
                    }
                }
            }
        }
        return dist[n-1][m-1];
    }
}