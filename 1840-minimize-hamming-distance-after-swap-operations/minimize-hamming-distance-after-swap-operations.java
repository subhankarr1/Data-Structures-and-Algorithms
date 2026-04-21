class Solution {
    private void DFS(int node, List<List<Integer>> adj, int[] vis, List<Integer> c) {
        vis[node] = 1;
        c.add(node);
        for (int i : adj.get(node)) {
            if (vis[i] == 0) {
                DFS(i, adj, vis, c);
            }
        }
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] i: allowedSwaps) {
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        int[] vis = new int[n];
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(vis[i] == 0) {
                List<Integer> c = new ArrayList<>();
                DFS(i, adj, vis, c);

                Map<Integer, Integer> mp = new HashMap<>();
                for(int j: c) {
                    mp.put(source[j], mp.getOrDefault(source[j], 0) + 1);
                }
                for(int j: c){
                    if(mp.getOrDefault(target[j], 0) >= 1) {
                        mp.put(target[j], mp.get(target[j]) - 1);
                    }
                    else ans++;
                }
            }
        }
        return ans;
    }
}