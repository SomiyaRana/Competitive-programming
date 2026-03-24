class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int mod = 12345;
        int n = grid.length, m = grid[0].length;
        int size = n * m;

        // Step 1: Flatten grid
        int[] arr = new int[size];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[idx++] = grid[i][j] % mod;
            }
        }

        // Step 2: Prefix product
        int[] prefix = new int[size];
        prefix[0] = 1;
        for (int i = 1; i < size; i++) {
            prefix[i] = (prefix[i - 1] * arr[i - 1]) % mod;
        }

        // Step 3: Suffix product
        int[] suffix = new int[size];
        suffix[size - 1] = 1;
        for (int i = size - 2; i >= 0; i--) {
            suffix[i] = (suffix[i + 1] * arr[i + 1]) % mod;
        }

        // Step 4: Build result
        int[][] res = new int[n][m];
        idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = (prefix[idx] * suffix[idx]) % mod;
                idx++;
            }
        }

        return res;
    }
}