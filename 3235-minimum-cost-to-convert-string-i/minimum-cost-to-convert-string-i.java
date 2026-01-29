class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] d = new long[26][26];
        for(int i = 0; i < 26; i++) {
            Arrays.fill(d[i], Long.MAX_VALUE);
            d[i][i] = 0;
        } 

        for(int i = 0; i < cost.length; i++) {
            d[original[i] - 'a'][changed[i] - 'a'] = Math.min(d[original[i] - 'a'][changed[i] - 'a'], cost[i]);
        }

        for(int k = 0; k < 26; k++) {
            for(int i = 0; i < 26; i++) {
                for(int j = 0; j < 26; j++) {
                    if(d[i][k] != Long.MAX_VALUE && d[k][j] != Long.MAX_VALUE) {
                        d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                    }
                }
            }
        }
        long ans = 0;
        for(int i = 0; i < source.length(); i++) {
            int src = source.charAt(i) - 'a';
            int dst= target.charAt(i) - 'a';
            if(d[src][dst] == Long.MAX_VALUE) return -1;
            ans += d[src][dst];
        }
        return ans;
    }
}