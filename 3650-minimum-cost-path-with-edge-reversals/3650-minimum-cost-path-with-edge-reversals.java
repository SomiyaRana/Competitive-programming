import java.util.*;

class Solution {
    static class Edge {
        int to, w;
        Edge(int t, int w) { this.to = t; this.w = w; }
    }

    static class Node {
        int u, used;
        long cost;
        Node(int u, int used, long cost) {
            this.u = u; this.used = used; this.cost = cost;
        }
    }

    public int minCost(int n, int[][] edges) {
        List<Edge>[] out = new ArrayList[n];
        List<Edge>[] in = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            out[i] = new ArrayList<>();
            in[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            out[e[0]].add(new Edge(e[1], e[2]));
            in[e[1]].add(new Edge(e[0], e[2]));
        }

        long INF = Long.MAX_VALUE / 4;
        long[][] dist = new long[n][2];
        for (long[] d : dist) Arrays.fill(d, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.cost));
        dist[0][0] = 0;
        pq.offer(new Node(0, 0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int u = cur.u, used = cur.used;
            long cost = cur.cost;

            if (cost != dist[u][used]) continue;
            if (u == n - 1) return (int) cost;

            // Normal outgoing edges
            for (Edge e : out[u]) {
                int v = e.to;
                long nc = cost + e.w;
                if (nc < dist[v][0]) {
                    dist[v][0] = nc;
                    pq.offer(new Node(v, 0, nc));
                }
            }

            // Use switch at u (only once)
            if (used == 0) {
                for (Edge e : in[u]) {
                    int v = e.to;
                    long nc = cost + 2L * e.w;
                    if (nc < dist[v][0]) {
                        dist[v][0] = nc;
                        pq.offer(new Node(v, 0, nc));
                    }
                }
            }
        }

        return -1;
    }
}
