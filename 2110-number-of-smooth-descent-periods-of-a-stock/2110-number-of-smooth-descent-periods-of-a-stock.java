class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans = 0;
        long len = 0;

        for (int i = 0; i < prices.length; i++) {
            if (i > 0 && prices[i - 1] - prices[i] == 1) {
                len++;
            } else {
                len = 1;
            }
            ans += len;
        }
        return ans;
    }
}
