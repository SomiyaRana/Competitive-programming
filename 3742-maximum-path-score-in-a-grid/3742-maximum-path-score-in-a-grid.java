import java.util.Arrays;

class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        // dp[j][c] = max score at column j with cost c
        int[][] dp = new int[n][k + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        dp[0][0] = 0;

        for (int i = 0; i < m; i++) {
            int[][] newDp = new int[n][k + 1];
            for (int[] row : newDp) Arrays.fill(row, -1);

            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                int cost = (val == 0) ? 0 : 1;
                int score = val;

                for (int c = 0; c <= k; c++) {

                    // from top (previous row)
                    if (dp[j][c] != -1) {
                        int nc = c + cost;
                        if (nc <= k) {
                            newDp[j][nc] = Math.max(newDp[j][nc], dp[j][c] + score);
                        }
                    }

                    // from left (same row, already updated)
                    if (j > 0 && newDp[j - 1][c] != -1) {
                        int nc = c + cost;
                        if (nc <= k) {
                            newDp[j][nc] = Math.max(newDp[j][nc], newDp[j - 1][c] + score);
                        }
                    }
                }
            }
            dp = newDp;
        }

        int ans = -1;
        for (int c = 0; c <= k; c++) {
            ans = Math.max(ans, dp[n - 1][c]);
        }

        return ans;
    }
}