class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        long NEG = Long.MIN_VALUE / 4;

        long[][] dp = new long[k + 1][3];

        for (int t = 0; t <= k; t++) {
            dp[t][0] = 0;     // free
            dp[t][1] = NEG;  // holding long
            dp[t][2] = NEG;  // holding short
        }

        for (int price : prices) {
            long[][] next = new long[k + 1][3];

            for (int t = 0; t <= k; t++) {
                next[t][0] = dp[t][0];
                next[t][1] = dp[t][1];
                next[t][2] = dp[t][2];
            }

            for (int t = 0; t <= k; t++) {
                // free → long
                next[t][1] = Math.max(next[t][1], dp[t][0] - price);

                // free → short
                next[t][2] = Math.max(next[t][2], dp[t][0] + price);

                // long → free (sell)
                if (t + 1 <= k)
                    next[t + 1][0] = Math.max(next[t + 1][0], dp[t][1] + price);

                // short → free (buy back)
                if (t + 1 <= k)
                    next[t + 1][0] = Math.max(next[t + 1][0], dp[t][2] - price);
            }

            dp = next;
        }

        long ans = 0;
        for (int t = 0; t <= k; t++) {
            ans = Math.max(ans, dp[t][0]);
        }
        return ans;
    }
}
