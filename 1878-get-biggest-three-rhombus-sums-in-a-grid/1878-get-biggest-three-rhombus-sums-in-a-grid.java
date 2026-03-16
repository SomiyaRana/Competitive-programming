import java.util.*;

class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // size 0 rhombus
                set.add(grid[i][j]);

                // try larger rhombus sizes
                for (int k = 1; i + 2 * k < m && j - k >= 0 && j + k < n; k++) {
                    int sum = 0;

                    int x = i, y = j;

                    // down-left
                    for (int d = 0; d < k; d++) {
                        sum += grid[x + d][y - d];
                    }

                    // down-right
                    for (int d = 0; d < k; d++) {
                        sum += grid[x + k + d][y - k + d];
                    }

                    // up-right
                    for (int d = 0; d < k; d++) {
                        sum += grid[x + 2 * k - d][y + d];
                    }

                    // up-left
                    for (int d = 0; d < k; d++) {
                        sum += grid[x + k - d][y + k - d];
                    }

                    set.add(sum);
                }
            }
        }

        int size = Math.min(3, set.size());
        int[] res = new int[size];
        int idx = 0;

        for (int val : set) {
            if (idx == size) break;
            res[idx++] = val;
        }

        return res;
    }
}