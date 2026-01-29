class Solution {
    private long[][] floydW(List<List<int[]>> adj) {
        long[][] d = new long[26][26];
        for(int i = 0; i < 26; i++) Arrays.fill(d[i], Long.MAX_VALUE);
        for(int i = 0; i < 26; i++) {
            for(int[] neighbour : adj.get(i)) {
                d[i][neighbour[0]] = Math.min(d[i][neighbour[0]], neighbour[1]);
            }
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
        return d;
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        List<List<int[]>> adj = new ArrayList<>();
        long ans = 0;
        for(int i = 0; i < 26; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < cost.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            int c = cost[i];
            adj.get(u).add(new int[]{v, c});
        }
        long[][] d = floydW(adj);
        for(int i = 0; i < target.length(); i++) {
            int src = source.charAt(i) - 'a';
            int dst = target.charAt(i) - 'a';
            if(source.charAt(i) != target.charAt(i)) {
                if(d[src][dst] == Long.MAX_VALUE) return -1;
                ans += d[src][dst];
            }
        }
        return ans;
    }
}