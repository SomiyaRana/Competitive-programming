import java.util.*;

public class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        // Sort robots and factories by position
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));

        int n = robot.size();
        int m = factory.length;

        // dp array where dp[i][j] represents the minimum distance for i robots with j factories
        long[][] dp = new long[n + 1][m + 1];
        for (int i = 0; i <= n; i++) Arrays.fill(dp[i], Long.MAX_VALUE);
        
        dp[0][0] = 0;

        // Iterate over each factory
        for (int j = 1; j <= m; j++) {
            int factoryPosition = factory[j - 1][0];
            int capacity = factory[j - 1][1];

            // Copy previous distances when not using this factory
            for (int i = 0; i <= n; i++) dp[i][j] = dp[i][j - 1];

            // Calculate the minimum distance by assigning robots to this factory
            for (int i = 1; i <= n; i++) {
                long distanceSum = 0;
                for (int k = 1; k <= capacity && i - k >= 0; k++) {
                    distanceSum += Math.abs(robot.get(i - k) - factoryPosition);
                    if (dp[i - k][j - 1] != Long.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - k][j - 1] + distanceSum);
                    }
                }
            }
        }

        return dp[n][m];
    }
}
