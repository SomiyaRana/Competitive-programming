class Solution {
    public int minInsertions(String s) {

        int open = 0;   // unmatched '('
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                open++;
            } else {

                // Check for "))"
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++; // consume next ')'
                } else {
                    // Need one more ')'
                    ans++;
                }

                // Match with '('
                if (open > 0) {
                    open--;
                } else {
                    // Need one '('
                    ans++;
                }
            }
        }

        // Each remaining '(' needs "))"
        ans += open * 2;

        return ans;
    }
}