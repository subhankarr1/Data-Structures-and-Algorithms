class tuple {
    int height, x, y;
    tuple(int height, int x, int y) {
        this.height = height;
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int trapRainWater(int[][] heightMap) {
        int n = heightMap.length, m = heightMap[0].length;
        boolean[][] vis = new boolean[n][m];
        PriorityQueue<tuple> pq = new PriorityQueue<>((a, b) -> a.height - b.height);
        
        for(int i = 0; i < n; i++) {
            pq.add(new tuple(heightMap[i][0], i, 0));
            pq.add(new tuple(heightMap[i][m-1], i, m-1));
            vis[i][0] = vis[i][m-1] = true;
        }
        for(int j = 0; j < m; j++) {
            pq.add(new tuple(heightMap[0][j], 0, j));
            pq.add(new tuple(heightMap[n-1][j], n-1, j));
            vis[0][j] = vis[n-1][j] = true;
        }
        int[] dirx = {-1, 0, +1, 0};
        int[] diry = {0, +1, 0, -1};
        int res = 0;
        while(!pq.isEmpty()) {
            tuple it = pq.poll();
            int height = it.height;
            int x = it.x;
            int y = it.y;

            for(int i = 0; i < 4; i++) {
                int nx = x + dirx[i];
                int ny = y + diry[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m && !vis[nx][ny]) {
                    vis[nx][ny] = true;
                    res += Math.max(0, height - heightMap[nx][ny]);
                    pq.add(new tuple(Math.max(height, heightMap[nx][ny]), nx, ny));
                }
            }
        }
        return res;
    }
}