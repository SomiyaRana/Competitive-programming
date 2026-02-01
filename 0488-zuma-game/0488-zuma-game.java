import java.util.*;

class Solution {
    Map<String, Integer> memo = new HashMap<>();

    public int findMinStep(String board, String hand) {
        int[] cnt = new int[26];
        for (char c : hand.toCharArray()) cnt[c - 'A']++;
        int res = dfs(board, cnt);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int dfs(String board, int[] cnt) {
        board = shrink(board);
        if (board.length() == 0) return 0;

        String key = board + Arrays.toString(cnt);
        if (memo.containsKey(key)) return memo.get(key);

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= board.length(); i++) {
            for (char c : new char[]{'R','Y','B','G','W'}) {
                if (cnt[c - 'A'] == 0) continue;

                // only insert if useful
                if (i > 0 && board.charAt(i - 1) == c ||
                    i < board.length() && board.charAt(i) == c ||
                    i > 0 && i < board.length() &&
                    board.charAt(i - 1) == board.charAt(i) &&
                    board.charAt(i) != c) {

                    cnt[c - 'A']--;
                    String next = board.substring(0, i) + c + board.substring(i);
                    int sub = dfs(next, cnt);
                    if (sub != Integer.MAX_VALUE)
                        ans = Math.min(ans, 1 + sub);
                    cnt[c - 'A']++;
                }
            }
        }

        memo.put(key, ans);
        return ans;
    }

    private String shrink(String s) {
        int i = 0;
        for (int j = 0; j <= s.length(); j++) {
            if (j == s.length() || s.charAt(j) != s.charAt(i)) {
                if (j - i >= 3) {
                    return shrink(s.substring(0, i) + s.substring(j));
                }
                i = j;
            }
        }
        return s;
    }
}
