class Solution {
    int[] parent;

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        union(0, firstPerson);

        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);

        int i = 0;
        while (i < meetings.length) {
            int time = meetings[i][2];
            List<int[]> temp = new ArrayList<>();

            while (i < meetings.length && meetings[i][2] == time) {
                union(meetings[i][0], meetings[i][1]);
                temp.add(meetings[i]);
                i++;
            }

            for (int[] m : temp) {
                if (find(m[0]) != find(0)) {
                    parent[m[0]] = m[0];
                    parent[m[1]] = m[1];
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int p = 0; p < n; p++) {
            if (find(p) == find(0))
                ans.add(p);
        }
        return ans;
    }

    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int a, int b) {
        parent[find(a)] = find(b);
    }
}

