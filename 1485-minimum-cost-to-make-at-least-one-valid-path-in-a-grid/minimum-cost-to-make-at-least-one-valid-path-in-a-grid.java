class tuple implements Comparable<tuple> {
    int row, col, cost;
    tuple(int row, int col, int cost) {
        this.row = row;
        this.col = col;
        this.cost = cost;
    }
    public int compareTo(tuple others) {
        return this.cost - others.cost;
    }
} 

class Solution {
    public int minCost(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dist = new int[n][m];
        for(int[] i: dist) Arrays.fill(i, (int)(1e9));
        PriorityQueue<tuple> pq = new PriorityQueue<>();
        pq.add(new tuple(0,0,0));
        dist[0][0] = 0;

        int[] dr = {0, 0, +1, -1};
        int[] dc = {+1, -1, 0, 0};

        while(!pq.isEmpty()) {
            tuple it = pq.poll();
            int row = it.row;
            int col = it.col;
            int cost = it.cost;
            if(cost > dist[row][col]) continue;
            if(row == n-1 && col == m-1) return cost;

            for(int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    int newCost = (grid[row][col] == i+1) ? 0 : 1;
                    if(cost + newCost < dist[nr][nc]) {
                        dist[nr][nc] = cost + newCost;
                        pq.add(new tuple(nr, nc, dist[nr][nc]));
                    }
                }
            }
         }
         return dist[n-1][m-1];
    }
}