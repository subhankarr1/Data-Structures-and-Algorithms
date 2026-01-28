class Edge {
    int neighbourNode;
    int ind;
    Edge(int neighbourNode, int ind) {
        this.neighbourNode = neighbourNode;
        this.ind = ind;
    }
}
class Solution {
    private void DFS(int u, int parent, List<List<Edge>> adj, int[] need, List<Integer> ans) {
        for(Edge e : adj.get(u)) {
            int v = e.neighbourNode;
            int originalInd = e.ind;
            if(v == parent) continue;
            DFS(v, u, adj, need, ans);
            if(need[v] == 1) {
                need[v] ^= 1;
                need[u] ^= 1;
                ans.add(originalInd);
            }
        }
    }
    public List<Integer> minimumFlips(int n, int[][] edges, String start, String target) {
        List<List<Edge>> adj = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < n-1; i++) {
            int u = edges[i][0], v = edges[i][1];
            adj.get(u).add(new Edge(v, i));
            adj.get(v).add(new Edge(u, i));
        }
        int[] need = new int[n];
        for(int i = 0; i < n; i++) need[i] = (start.charAt(i) != target.charAt(i)) ? 1 : 0;
        DFS(0, -1, adj, need, ans);
        if(need[0] == 1) return List.of(-1);
        Collections.sort(ans);
        return ans;
    }
}