class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        int half = k / 2;

        long base = 0;
        for (int i = 0; i < n; i++) {
            base += (long) strategy[i] * prices[i];
        }

        long[] lose = new long[n];
        long[] gain = new long[n];

        for (int i = 0; i < n; i++) {
            lose[i] = -(long) strategy[i] * prices[i];
            gain[i] = (long) (1 - strategy[i]) * prices[i];
        }

        long leftSum = 0, rightSum = 0;

        // initial window
        for (int i = 0; i < half; i++) leftSum += lose[i];
        for (int i = half; i < k; i++) rightSum += gain[i];

        long bestDelta = leftSum + rightSum;

        // slide window
        for (int l = 1; l + k <= n; l++) {
            leftSum -= lose[l - 1];
            leftSum += lose[l + half - 1];

            rightSum -= gain[l + half - 1];
            rightSum += gain[l + k - 1];

            bestDelta = Math.max(bestDelta, leftSum + rightSum);
        }

        return base + Math.max(0, bestDelta);
    }
}
