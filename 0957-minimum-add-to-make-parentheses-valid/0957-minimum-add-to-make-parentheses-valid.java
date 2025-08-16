public class Solution {
    public int minAddToMakeValid(String s) {
        int left = 0;  // To count unmatched '('
        int right = 0; // To count unmatched ')'

        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else {
                if (left > 0) {
                    left--; // Match with an unmatched '('
                } else {
                    right++; // Unmatched ')'
                }
            }
        }

        return left + right; // Total unmatched parentheses
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minAddToMakeValid("())")); // Output: 1
        System.out.println(solution.minAddToMakeValid("(((")); // Output: 3
    }
}
