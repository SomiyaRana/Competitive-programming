class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length, n = coins[0].length;
        int[][][] dp = new int[m][n][3];

        // initialize with very small values
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }

        // start
        dp[0][0][0] = coins[0][0];
        if (coins[0][0] < 0) dp[0][0][1] = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= 2; k++) {
                    if (dp[i][j][k] == Integer.MIN_VALUE) continue;

                    int[][] dirs = {{0,1},{1,0}};
                    for (int[] d : dirs) {
                        int ni = i + d[0], nj = j + d[1];
                        if (ni >= m || nj >= n) continue;

                        int val = coins[ni][nj];

                        // take normally
                        dp[ni][nj][k] = Math.max(dp[ni][nj][k],
                                dp[i][j][k] + val);

                        // neutralize if negative
                        if (val < 0 && k < 2) {
                            dp[ni][nj][k+1] = Math.max(dp[ni][nj][k+1],
                                    dp[i][j][k]);
                        }
                    }
                }
            }
        }

        return Math.max(dp[m-1][n-1][0],
               Math.max(dp[m-1][n-1][1], dp[m-1][n-1][2]));
    }
}