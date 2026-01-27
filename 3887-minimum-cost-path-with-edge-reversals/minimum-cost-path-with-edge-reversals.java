class Edge {
    int x;
    long weight;
    Edge(int x, long weight) {
        this.x = x;
        this.weight = weight;
    }
}
class State {
    int node;
    long distance;
    State(int node, long distance) {
        this.node = node;
        this.distance = distance;
    }
}
class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<Edge>> graph = new ArrayList<>();
        List<List<Edge>> rev = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            rev.add(new ArrayList<>());
        }
        for(int[] e : edges) {
            int a = e[0], b = e[1], c = e[2];
            graph.get(a).add(new Edge(b, c));
            rev.get(b).add(new Edge(a, 2L * c));
        }
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Long.compare(a.distance, b.distance));
        pq.add(new State(0, 0));
        
        long[] dist = new long[n];
        Arrays.fill(dist, (int)(1e9));
        dist[0] = 0;

        while(!pq.isEmpty()) {
            State it = pq.poll();
            int u = it.node;
            long d = it.distance;
            if(d > dist[u]) continue;
            if(u == n-1) return (int)d;

            for(Edge e : graph.get(u)) {
                int v = e.x;
                long w = e.weight;
                if(dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new State(v, dist[v]));
                }
            }
            for(Edge e : rev.get(u)) {
                int v = e.x;
                long w = e.weight;
                if(dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new State(v, dist[v]));
                }
            }
        }
        return -1;
    }
}