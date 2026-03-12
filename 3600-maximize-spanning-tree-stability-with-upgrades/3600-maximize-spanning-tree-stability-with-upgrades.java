import java.util.*;

class Solution {

    class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) return false;

            if (rank[pa] < rank[pb])
                parent[pa] = pb;
            else if (rank[pa] > rank[pb])
                parent[pb] = pa;
            else {
                parent[pb] = pa;
                rank[pa]++;
            }
            return true;
        }
    }

    public int maxStability(int n, int[][] edges, int k) {

        int left = 0;
        int right = 200000;
        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canBuild(n, edges, k, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    private boolean canBuild(int n, int[][] edges, int k, int minStrength) {

        DSU dsu = new DSU(n);
        int upgrades = 0;
        int used = 0;

        // process must edges first
        for (int[] e : edges) {
            if (e[3] == 1) {
                if (e[2] < minStrength) return false;

                if (!dsu.union(e[0], e[1]))
                    return false;

                used++;
            }
        }

        List<int[]> optional = new ArrayList<>();

        for (int[] e : edges)
            if (e[3] == 0)
                optional.add(e);

        optional.sort((a, b) -> Integer.compare(b[2], a[2]));

        for (int[] e : optional) {

            if (used == n - 1)
                break;

            int u = e[0];
            int v = e[1];
            int s = e[2];

            if (dsu.find(u) == dsu.find(v))
                continue;

            if (s >= minStrength) {
                dsu.union(u, v);
                used++;
            } else if (2 * s >= minStrength && upgrades < k) {
                upgrades++;
                dsu.union(u, v);
                used++;
            }
        }

        return used == n - 1;
    }
}