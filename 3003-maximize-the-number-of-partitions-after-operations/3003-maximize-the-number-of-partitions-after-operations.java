import java.util.*;

class Solution {

    Map<String, Integer> memo = new HashMap<>();

    public int maxPartitionsAfterOperations(String s, int k) {
        return dfs(s, 0, 0, false, k);
    }

    private int dfs(String s, int i, int mask, boolean changed, int k) {
        if (i == s.length()) return 1;

        String key = i + "," + mask + "," + changed;
        if (memo.containsKey(key)) return memo.get(key);

        int ans = 0;

        int bit = 1 << (s.charAt(i) - 'a');
        int newMask = mask | bit;

        if (Integer.bitCount(newMask) > k) {
            ans = Math.max(ans, 1 + dfs(s, i + 1, bit, changed, k));
        } else {
            ans = Math.max(ans, dfs(s, i + 1, newMask, changed, k));
        }

        if (!changed) {
            for (int c = 0; c < 26; c++) {
                int b = 1 << c;
                int nm = mask | b;

                if (Integer.bitCount(nm) > k) {
                    ans = Math.max(ans, 1 + dfs(s, i + 1, b, true, k));
                } else {
                    ans = Math.max(ans, dfs(s, i + 1, nm, true, k));
                }
            }
        }

        memo.put(key, ans);
        return ans;
    }
}