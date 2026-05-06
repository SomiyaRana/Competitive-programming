class Solution {
    public int matrixScore(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // Step 1: Make first column all 1s
        for (int i = 0; i < m; i++) {

            if (grid[i][0] == 0) {

                // Flip entire row
                for (int j = 0; j < n; j++) {
                    grid[i][j] ^= 1;
                }
            }
        }

        // Step 2: For each column, maximize number of 1s
        for (int j = 1; j < n; j++) {

            int ones = 0;

            for (int i = 0; i < m; i++) {
                ones += grid[i][j];
            }

            // If zeros are more, flip column
            if (ones < m - ones) {

                for (int i = 0; i < m; i++) {
                    grid[i][j] ^= 1;
                }
            }
        }

        // Step 3: Calculate final score
        int score = 0;

        for (int i = 0; i < m; i++) {

            int num = 0;

            for (int j = 0; j < n; j++) {
                num = num * 2 + grid[i][j];
            }

            score += num;
        }

        return score;
    }
}