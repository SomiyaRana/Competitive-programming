class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // If start is blocked
        if (obstacleGrid[0][0] == 1) return 0;

        // Use the grid itself as DP
        obstacleGrid[0][0] = 1;

        // First column
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                obstacleGrid[i][0] = obstacleGrid[i - 1][0];
            } else {
                obstacleGrid[i][0] = 0;
            }
        }

        // First row
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 0) {
                obstacleGrid[0][j] = obstacleGrid[0][j - 1];
            } else {
                obstacleGrid[0][j] = 0;
            }
        }

        // Rest of the grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] =
                        obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        return obstacleGrid[m - 1][n - 1];
    }
}
