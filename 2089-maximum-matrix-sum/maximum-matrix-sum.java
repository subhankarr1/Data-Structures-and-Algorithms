class Solution {
    public long maxMatrixSum(int[][] matrix) {
        
        int n = matrix.length, m = matrix[0].length;
        long cnt = 0, mini = Integer.MAX_VALUE, sum = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(matrix[i][j] < 0)
                {
                    cnt++;
                }
                long val = Math.abs(matrix[i][j]);
                mini = Math.min(mini, val);
                sum += val;
            }
        }
        if(cnt % 2 == 0) return sum;
        return sum - 2 * mini;

    }
}