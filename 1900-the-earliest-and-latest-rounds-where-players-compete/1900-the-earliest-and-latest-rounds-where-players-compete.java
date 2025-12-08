import java.util.Arrays;

class Solution {
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        // mem[l][r][k] = {earliest, latest}
        int[][][][] mem = new int[n + 1][n + 1][n + 1][2];
        // Notice we transform secondPlayer to "from the end":
        // l = position from front, r = position from end
        return solve(firstPlayer, n - secondPlayer + 1, n, mem);
    }

    // Returns [earliest, latest] when:
    // - first player is at position l from the FRONT (1-based)
    // - second player is at position r from the BACK (1-based)
    // - there are k total players in this round
    private int[] solve(int l, int r, int k, int[][][][] mem) {
        if (l == r) {
            return new int[]{1, 1};
        }

        if (l > r) {
            return solve(r, l, k, mem);
        }

        if (!Arrays.equals(mem[l][r][k], new int[]{0, 0})) {
            return mem[l][r][k];
        }

        int earliest = Integer.MAX_VALUE;
        int latest = Integer.MIN_VALUE;

      
        for (int i = 1; i <= l; ++i) {
            for (int j = l - i + 1; j <= r - i; ++j) {
                if (i + j > (k + 1) / 2 || i + j < l + r - k / 2) {
                    continue;
                }

                int[] res = solve(i, j, (k + 1) / 2, mem);
                earliest = Math.min(earliest, res[0] + 1);
                latest = Math.max(latest, res[1] + 1);
            }
        }

        mem[l][r][k] = new int[]{earliest, latest};
        return mem[l][r][k];
    }
}
