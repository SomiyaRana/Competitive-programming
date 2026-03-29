class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;

        // Step 1: Basic validation
        for (int i = 0; i < n; i++) {
            if (lcp[i][i] != n - i) return "";
            for (int j = 0; j < n; j++) {
                if (lcp[i][j] != lcp[j][i]) return "";
            }
        }

        // Step 2: Union-Find
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (lcp[i][j] > 0) {
                    union(parent, i, j);
                }
            }
        }

        // Step 3: Assign smallest characters
        char[] res = new char[n];
        char curr = 'a';
        int[] map = new int[n];
        Arrays.fill(map, -1);

        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            if (map[root] == -1) {
                if (curr > 'z') return ""; // too many groups
                map[root] = curr++;
            }
            res[i] = (char) map[root];
        }

        String word = new String(res);

        // Step 4: Validate LCP
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (word.charAt(i) == word.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] != lcp[i][j]) return "";
            }
        }

        return word;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x)
            parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    private void union(int[] parent, int a, int b) {
        int pa = find(parent, a);
        int pb = find(parent, b);
        if (pa != pb) parent[pa] = pb;
    }
}