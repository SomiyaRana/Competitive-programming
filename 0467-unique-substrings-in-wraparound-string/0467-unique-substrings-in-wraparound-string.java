class Solution {
    public int findSubstringInWraproundString(String s) {
        int[] dp = new int[26];  // dp[c] = max length ending with char c
        int currLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (i > 0) {
                char prev = s.charAt(i - 1);
                // check consecutive with wraparound
                if ((curr - prev == 1) || (prev == 'z' && curr == 'a')) {
                    currLen++;
                } else {
                    currLen = 1;
                }
            } else {
                currLen = 1;
            }

            int idx = curr - 'a';
            dp[idx] = Math.max(dp[idx], currLen);
        }

        int result = 0;
        for (int val : dp) {
            result += val;
        }

        return result;
    }
}
