class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] pal = new boolean[n][n];

        for (int end = 0; end < n; end++) {
            for (int start = end; start >= 0; start--) {
                if (s.charAt(start) == s.charAt(end) &&
                   (end - start <= 2 || pal[start + 1][end - 1])) {
                    pal[start][end] = true;
                }
            }
        }

        int[] cuts = new int[n];
        for (int i = 0; i < n; i++) {
            if (pal[0][i]) {
                cuts[i] = 0;     
            } else {
                int best = Integer.MAX_VALUE;
                for (int j = 1; j <= i; j++) {
                    if (pal[j][i]) {
                        best = Math.min(best, cuts[j - 1] + 1);
                    }
                }
                cuts[i] = best;
            }
        }

        return cuts[n - 1];
    }
}
