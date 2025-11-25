import java.util.*;

class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> map = new HashMap<>();

        for (int p : power) {
            map.put(p, map.getOrDefault(p, 0L) + p);
        }

        int m = map.size();
        int[] vals = new int[m];
        long[] sum = new long[m];

        int idx = 0;
        for (int key : map.keySet()) {
            vals[idx] = key;
            idx++;
        }

        Arrays.sort(vals);

        for (int i = 0; i < m; i++) {
            sum[i] = map.get(vals[i]);
        }

        long[] dp = new long[m + 1];

        // Build dp from right to left
        for (int i = m - 1; i >= 0; i--) {
            int nextVal = vals[i] + 3;

            int j = Arrays.binarySearch(vals, nextVal);
            if (j < 0) j = -j - 1;

            long take = sum[i] + dp[j];
            long skip = dp[i + 1];

            dp[i] = Math.max(take, skip);
        }

        return dp[0];
    }
}
