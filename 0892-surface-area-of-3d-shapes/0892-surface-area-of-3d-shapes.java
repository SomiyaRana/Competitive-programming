class Solution {
    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int area = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int h = grid[i][j];
                
                if (h > 0) {
                    // top + bottom + sides
                    area += 4 * h + 2;

                    // overlap with top neighbor
                    if (i > 0) {
                        area -= 2 * Math.min(h, grid[i - 1][j]);
                    }

                    // overlap with left neighbor
                    if (j > 0) {
                        area -= 2 * Math.min(h, grid[i][j - 1]);
                    }
                }
            }
        }

        return area;
    }
}