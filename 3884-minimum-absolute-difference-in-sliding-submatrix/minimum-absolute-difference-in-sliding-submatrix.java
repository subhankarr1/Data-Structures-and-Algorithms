class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        int[][] res = new int[n-k+1][m-k+1];
        for(int i = 0; i <= n-k; i++)
        {
            for(int j = 0; j <= m-k; j++)
            {
                TreeSet<Integer> sortedVals = new TreeSet<>();
                for(int r = i; r <= i+k-1; r++)
                {
                    for(int c = j; c <= j+k-1; c++)
                    {
                        sortedVals.add(grid[r][c]);
                    }
                }
                if(sortedVals.size() ==  1) continue;

                Integer prev = null;
                int miniDiff = Integer.MAX_VALUE;
                for(int curr : sortedVals) {
                    if(prev != null) {
                        miniDiff = Math.min(miniDiff, curr - prev);
                    }
                 prev = curr;
                }
                res[i][j] = miniDiff;
            }
        }
        return res;
    }
}