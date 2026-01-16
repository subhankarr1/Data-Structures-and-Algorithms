class tuple {
    int row, col, cost;
    tuple(int row, int col, int cost) {
        this.row = row;
        this.col = col;
        this.cost = cost;
    }
}
class Solution {
    public int minCost(int[][] grid) {

        int n = grid.length, m = grid[0].length;
        int[][] dist = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dist[i][j] = (int)(1e9);
            }
        }
        Deque<tuple> dq = new ArrayDeque<>();
        dq.offerFirst(new tuple(0,0,0));
        dist[0][0] = 0;

        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};

        while(!dq.isEmpty()) {
            tuple it = dq.pollFirst();
            int row = it.row;
            int col = it.col;
            int cost = it.cost;
            if(cost > dist[row][col]) continue;
            if(row == n-1 && col == m-1) return cost;

            for(int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    int addCost = (grid[row][col] == i+1) ? 0 : 1;
                    int newCost = cost + addCost;

                    if(newCost < dist[nr][nc]) {
                        dist[nr][nc] = newCost;
                        if(addCost == 0) dq.offerFirst(new tuple(nr, nc, newCost));
                        else dq.offerLast(new tuple(nr, nc, newCost)); 
                    }
                }
            }
        }
        return dist[n-1][m-1];
    }
}